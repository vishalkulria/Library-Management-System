import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;

class Book {
    String title, author, isbn, category;
    int quantity;

    Book(String title, String author, String isbn, String category, int quantity) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.category = category;
        this.quantity = quantity;
    }

    public String toString() {
        return title + " | " + author + " | " + isbn + " | " + category + " | Qty: " + quantity;
    }
}

class Student {
    String studentId, name, phone;
    ArrayList<IssuedBook> issuedBooks;

    Student(String studentId, String name, String phone) {
        this.studentId = studentId;
        this.name = name;
        this.phone = phone;
        this.issuedBooks = new ArrayList<>();
    }

    public String toString() {
        return studentId + " - " + name + " (" + phone + ")";
    }
}

class IssuedBook {
    Book book;
    LocalDate issueDate;
    LocalDate dueDate;
    LocalDate returnDate;
    double fine;

    IssuedBook(Book book, LocalDate issueDate, LocalDate dueDate) {
        this.book = book;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = null;
        this.fine = 0;
    }

    public String getStatus() {
        if (returnDate != null) {
            return "Returned on " + returnDate;
        } else {
            long daysOverdue = ChronoUnit.DAYS.between(dueDate, LocalDate.now());
            if (daysOverdue > 0) {
                this.fine = daysOverdue * 5.0;
                return "Overdue by " + daysOverdue + " days. Fine: Rs" + fine;
            }
            return "Active";
        }
    }
}

public class LibraryManagementSystem extends JFrame {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private JTabbedPane tabbedPane;
    private DefaultTableModel bookTableModel, studentTableModel, issuedTableModel;

    public LibraryManagementSystem() {
        setTitle("Advanced Library Management System");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();

        // Book Management Tab
        tabbedPane.addTab("Book Management", createBookPanel());

        // Student Management Tab
        tabbedPane.addTab("Student Management", createStudentPanel());

        // Search Books Tab
        tabbedPane.addTab("Search Books", createSearchPanel());

        // Issue & Return Tab
        tabbedPane.addTab("Issue & Return Books", createIssueReturnPanel());

        add(tabbedPane);
        setVisible(true);
    }

    private JPanel createBookPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Add/Update Book"));
        
        JTextField titleField = new JTextField();
        JTextField authorField = new JTextField();
        JTextField isbnField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField quantityField = new JTextField();
        
        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Author:"));
        inputPanel.add(authorField);
        inputPanel.add(new JLabel("ISBN:"));
        inputPanel.add(isbnField);
        inputPanel.add(new JLabel("Category:"));
        inputPanel.add(categoryField);
        inputPanel.add(new JLabel("Quantity:"));
        inputPanel.add(quantityField);

        JButton addBtn = new JButton("Add Book");
        JButton updateBtn = new JButton("Update Book");
        JButton removeBtn = new JButton("Remove Book");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addBtn);
        buttonPanel.add(updateBtn);
        buttonPanel.add(removeBtn);
        inputPanel.add(buttonPanel);

        // Table for Books
        bookTableModel = new DefaultTableModel(new String[]{"Title", "Author", "ISBN", "Category", "Quantity"}, 0);
        JTable bookTable = new JTable(bookTableModel);
        JScrollPane scrollPane = new JScrollPane(bookTable);

        // Button Actions
        addBtn.addActionListener(e -> {
            String title = titleField.getText().trim();
            String author = authorField.getText().trim();
            String isbn = isbnField.getText().trim();
            String category = categoryField.getText().trim();
            String qtyStr = quantityField.getText().trim();

            if (!title.isEmpty() && !author.isEmpty() && !isbn.isEmpty() && !category.isEmpty() && !qtyStr.isEmpty()) {
                try {
                    int qty = Integer.parseInt(qtyStr);
                    Book book = new Book(title, author, isbn, category, qty);
                    books.add(book);
                    bookTableModel.addRow(new Object[]{title, author, isbn, category, qty});
                    clearBookFields(titleField, authorField, isbnField, categoryField, quantityField);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Quantity must be a number!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please fill all fields!");
            }
        });

        updateBtn.addActionListener(e -> {
            int selectedRow = bookTable.getSelectedRow();
            if (selectedRow != -1) {
                String title = titleField.getText().trim();
                String author = authorField.getText().trim();
                String isbn = isbnField.getText().trim();
                String category = categoryField.getText().trim();
                String qtyStr = quantityField.getText().trim();

                if (!title.isEmpty() && !author.isEmpty() && !isbn.isEmpty() && !category.isEmpty() && !qtyStr.isEmpty()) {
                    try {
                        int qty = Integer.parseInt(qtyStr);
                        books.get(selectedRow).title = title;
                        books.get(selectedRow).author = author;
                        books.get(selectedRow).isbn = isbn;
                        books.get(selectedRow).category = category;
                        books.get(selectedRow).quantity = qty;
                        
                        bookTableModel.setValueAt(title, selectedRow, 0);
                        bookTableModel.setValueAt(author, selectedRow, 1);
                        bookTableModel.setValueAt(isbn, selectedRow, 2);
                        bookTableModel.setValueAt(category, selectedRow, 3);
                        bookTableModel.setValueAt(qty, selectedRow, 4);
                        clearBookFields(titleField, authorField, isbnField, categoryField, quantityField);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Quantity must be a number!");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please fill all fields!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Select a book to update!");
            }
        });

        removeBtn.addActionListener(e -> {
            int selectedRow = bookTable.getSelectedRow();
            if (selectedRow != -1) {
                books.remove(selectedRow);
                bookTableModel.removeRow(selectedRow);
                clearBookFields(titleField, authorField, isbnField, categoryField, quantityField);
            } else {
                JOptionPane.showMessageDialog(this, "Select a book to remove!");
            }
        });

        bookTable.getSelectionModel().addListSelectionListener(e -> {
            int row = bookTable.getSelectedRow();
            if (row != -1) {
                titleField.setText((String) bookTableModel.getValueAt(row, 0));
                authorField.setText((String) bookTableModel.getValueAt(row, 1));
                isbnField.setText((String) bookTableModel.getValueAt(row, 2));
                categoryField.setText((String) bookTableModel.getValueAt(row, 3));
                quantityField.setText(String.valueOf(bookTableModel.getValueAt(row, 4)));
            }
        });

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createStudentPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Add Student"));

        JTextField studentIdField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField phoneField = new JTextField();

        inputPanel.add(new JLabel("Student ID:"));
        inputPanel.add(studentIdField);
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Phone:"));
        inputPanel.add(phoneField);

        JButton addBtn = new JButton("Add Student");
        JButton removeBtn = new JButton("Remove Student");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addBtn);
        buttonPanel.add(removeBtn);
        inputPanel.add(buttonPanel);

        studentTableModel = new DefaultTableModel(new String[]{"Student ID", "Name", "Phone", "Books Issued"}, 0);
        JTable studentTable = new JTable(studentTableModel);
        JScrollPane scrollPane = new JScrollPane(studentTable);

        addBtn.addActionListener(e -> {
            String studentId = studentIdField.getText().trim();
            String name = nameField.getText().trim();
            String phone = phoneField.getText().trim();

            if (!studentId.isEmpty() && !name.isEmpty() && !phone.isEmpty()) {
                Student student = new Student(studentId, name, phone);
                students.add(student);
                studentTableModel.addRow(new Object[]{studentId, name, phone, 0});
                studentIdField.setText("");
                nameField.setText("");
                phoneField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please fill all fields!");
            }
        });

        removeBtn.addActionListener(e -> {
            int selectedRow = studentTable.getSelectedRow();
            if (selectedRow != -1) {
                students.remove(selectedRow);
                studentTableModel.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "Select a student to remove!");
            }
        });

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createSearchPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel searchPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        searchPanel.setBorder(BorderFactory.createTitledBorder("Search Books"));

        JTextField searchField = new JTextField();
        JComboBox<String> searchTypeCombo = new JComboBox<>(new String[]{"Title", "Author", "Category"});

        searchPanel.add(new JLabel("Search by:"));
        searchPanel.add(searchTypeCombo);
        searchPanel.add(new JLabel("Enter value:"));
        searchPanel.add(searchField);

        JButton searchBtn = new JButton("Search");
        JButton clearBtn = new JButton("Clear");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(searchBtn);
        buttonPanel.add(clearBtn);
        searchPanel.add(buttonPanel);

        DefaultTableModel searchTableModel = new DefaultTableModel(new String[]{"Title", "Author", "ISBN", "Category", "Quantity"}, 0);
        JTable searchTable = new JTable(searchTableModel);
        JScrollPane scrollPane = new JScrollPane(searchTable);

        searchBtn.addActionListener(e -> {
            String searchType = (String) searchTypeCombo.getSelectedItem();
            String searchValue = searchField.getText().trim().toLowerCase();
            searchTableModel.setRowCount(0);

            if (searchValue.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a search value!");
                return;
            }

            for (Book book : books) {
                boolean match = false;
                if (searchType.equals("Title") && book.title.toLowerCase().contains(searchValue)) {
                    match = true;
                } else if (searchType.equals("Author") && book.author.toLowerCase().contains(searchValue)) {
                    match = true;
                } else if (searchType.equals("Category") && book.category.toLowerCase().contains(searchValue)) {
                    match = true;
                }

                if (match) {
                    searchTableModel.addRow(new Object[]{book.title, book.author, book.isbn, book.category, book.quantity});
                }
            }

            JOptionPane.showMessageDialog(this, "Found " + searchTableModel.getRowCount() + " book(s)");
        });

        clearBtn.addActionListener(e -> {
            searchField.setText("");
            searchTableModel.setRowCount(0);
        });

        panel.add(searchPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createIssueReturnPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel issuePanel = new JPanel(new GridLayout(6, 2, 5, 5));
        issuePanel.setBorder(BorderFactory.createTitledBorder("Issue/Return Books"));

        JComboBox<String> studentCombo = new JComboBox<>();
        JComboBox<String> bookCombo = new JComboBox<>();
        JTextField dueDaysField = new JTextField();

        issuePanel.add(new JLabel("Select Student:"));
        issuePanel.add(studentCombo);
        issuePanel.add(new JLabel("Select Book:"));
        issuePanel.add(bookCombo);
        issuePanel.add(new JLabel("Due Days:"));
        issuePanel.add(dueDaysField);

        JButton issueBtn = new JButton("Issue Book");
        JButton returnBtn = new JButton("Return Book");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(issueBtn);
        buttonPanel.add(returnBtn);
        issuePanel.add(buttonPanel);

        issuedTableModel = new DefaultTableModel(new String[]{"Student", "Book", "Issue Date", "Due Date", "Status"}, 0);
        JTable issuedTable = new JTable(issuedTableModel);
        JScrollPane scrollPane = new JScrollPane(issuedTable);

        issueBtn.addActionListener(e -> {
            if (students.isEmpty() || books.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Add students and books first!");
                return;
            }

            int studentIdx = studentCombo.getSelectedIndex();
            int bookIdx = bookCombo.getSelectedIndex();
            String dueDaysStr = dueDaysField.getText().trim();

            if (studentIdx == -1 || bookIdx == -1 || dueDaysStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please select student, book, and enter due days!");
                return;
            }

            try {
                int dueDays = Integer.parseInt(dueDaysStr);
                Student student = students.get(studentIdx);
                Book book = books.get(bookIdx);

                LocalDate issueDate = LocalDate.now();
                LocalDate dueDate = issueDate.plusDays(dueDays);
                
                IssuedBook issuedBook = new IssuedBook(book, issueDate, dueDate);
                student.issuedBooks.add(issuedBook);
                
                book.quantity--;
                bookTableModel.setValueAt(book.quantity, bookIdx, 4);
                
                studentTableModel.setValueAt((int) studentTableModel.getValueAt(studentIdx, 3) + 1, studentIdx, 3);
                
                issuedTableModel.addRow(new Object[]{student.name, book.title, issueDate, dueDate, "Active"});
                
                JOptionPane.showMessageDialog(this, "Book issued successfully!");
                dueDaysField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Due days must be a number!");
            }
        });

        returnBtn.addActionListener(e -> {
            int selectedRow = issuedTable.getSelectedRow();
            if (selectedRow != -1) {
                String status = (String) issuedTableModel.getValueAt(selectedRow, 4);
                if (!status.equals("Active")) {
                    JOptionPane.showMessageDialog(this, "This book is already returned!");
                    return;
                }

                String studentName = (String) issuedTableModel.getValueAt(selectedRow, 0);
                String bookTitle = (String) issuedTableModel.getValueAt(selectedRow, 1);
                
                for (Student student : students) {
                    if (student.name.equals(studentName)) {
                        for (IssuedBook issuedBook : student.issuedBooks) {
                            if (issuedBook.book.title.equals(bookTitle) && issuedBook.returnDate == null) {
                                issuedBook.returnDate = LocalDate.now();
                                issuedBook.getStatus();
                                
                                issuedBook.book.quantity++;
                                for (int i = 0; i < books.size(); i++) {
                                    if (books.get(i).title.equals(bookTitle)) {
                                        bookTableModel.setValueAt(issuedBook.book.quantity, i, 4);
                                        break;
                                    }
                                }
                                
                                String fineMsg = issuedBook.fine > 0 ? "\nFine: Rs" + issuedBook.fine : "";
                                JOptionPane.showMessageDialog(this, "Book returned successfully!" + fineMsg);
                                
                                issuedTableModel.setValueAt(issuedBook.getStatus(), selectedRow, 4);
                                return;
                            }
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Select a book to return!");
            }
        });

        studentCombo.addActionListener(e -> {
            bookCombo.removeAllItems();
            for (Book book : books) {
                if (book.quantity > 0) {
                    bookCombo.addItem(book.title);
                }
            }
        });

        if (!students.isEmpty()) {
            for (Student student : students) {
                studentCombo.addItem(student.name);
            }
        }

        panel.add(issuePanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private void clearBookFields(JTextField... fields) {
        for (JTextField field : fields) {
            field.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibraryManagementSystem());
    }
}
