
package javadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

public class JavaData {

   public static Connection con() {
    Connection connection = null; // متغير من نوع كونكشن لو الاتصال اشتغل قيمته هتتغير
    try {
        String url = "jdbc:ucanaccess://C:/Users/Administrator/Documents/NetBeansProjects/javaData/DataBase/Online market IS project.accdb"; // الباث بتاع الداتا بيز
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); // تحميل الدرايفر اللي بيسمح لجافا بالاتصال بالداتا بيز اكسيسس
        connection = DriverManager.getConnection(url); // الاتصال بالداتا بيز عن طريق الباث
        JOptionPane.showMessageDialog(null, "connection successful");
    } catch (ClassNotFoundException e) { // لو ملقناش الدرايفر
        JOptionPane.showMessageDialog(null, "Driver Not Found: " + e.getMessage());
    } catch (SQLException e) { // لو حصل مشكلة في الاتصال زي مثلا الباث غلط
        JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
    }
    return connection; // لو الاتصال نجح هيرجع كونكشن

}
    
    
    
    public static void updateQuery() {
        String[] updateOptions = {"Update Name", "Update PhoneNumber", "Update Address", "Update_product_stock", "product_price_update", "Back"};
        while (true) {
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Choose what to update:",
                    "Update Options",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    updateOptions,
                    null
            );

            switch (choice) {
                case 0: 
                    updateName();
                    break;
                case 1: 
                    updatePhoneNumber();
                    break;
                case 2: 
                    updateAddress();
                    break;

                case 3: 
                    product_stock();
                    break;
                case 4: 
                    updateproduct_price();
                    break;

                case 5,-1: 
                    return; 
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice!");
            }
        }
    }

    public static void updateName() {
        int customerId = Integer.parseInt(JOptionPane.showInputDialog("Enter customer ID:"));
        String newName = JOptionPane.showInputDialog("Enter new name:");

        Connection conn = con();
        if (conn != null) {
            try {
                String query = "UPDATE customer SET customer_name = ? WHERE customer_id = ?";
                PreparedStatement pstmt = conn.prepareStatement(query);

                pstmt.setString(1, newName);
                pstmt.setInt(2, customerId);

                int rowsUpdated = pstmt.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Customer's name updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No customer found with the given ID.");
                }

                pstmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
            }
        }
    }

    public static void updatePhoneNumber() {
        int customerId = Integer.parseInt(JOptionPane.showInputDialog("Enter customer ID:"));
        String newPhoneNumber = JOptionPane.showInputDialog("Enter new PhoneNumber:");

        Connection conn = con();
        if (conn != null) {
            try {
                String query = "UPDATE customer SET phone_number = ? WHERE customer_id = ?";
                PreparedStatement pstmt = conn.prepareStatement(query);

                pstmt.setString(1, newPhoneNumber);
                pstmt.setInt(2, customerId);

                int rowsUpdated = pstmt.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Customer's PhoneNumber updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No customer found with the given ID.");
                }

                pstmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
            }
        }
    }

    public static void updateAddress() {
        int customerId = Integer.parseInt(JOptionPane.showInputDialog("Enter customer ID:"));
        String newAddress = JOptionPane.showInputDialog("Enter new address:");

        Connection conn = con();
        if (conn != null) {
            try {
                String query = "UPDATE customer SET Address = ? WHERE customer_id = ?";
                PreparedStatement pstmt = conn.prepareStatement(query);

                pstmt.setString(1, newAddress);
                pstmt.setInt(2, customerId);

                int rowsUpdated = pstmt.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Customer's Address updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No customer found with the given ID.");
                }

                pstmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
            }
        }
    }

    public static void updateproduct_price() {
        int productId = Integer.parseInt(JOptionPane.showInputDialog("Enter product ID:"));
        String newPrice = JOptionPane.showInputDialog("Enter Price:");

        Connection conn = con();
        if (conn != null) {
            try {
                String query = "UPDATE product SET price = ? WHERE product_id = ?";
                PreparedStatement pstmt = conn.prepareStatement(query);

                pstmt.setString(1, newPrice);
                pstmt.setInt(2, productId);

                int rowsUpdated = pstmt.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "product price updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No product found with the given ID.");
                }

                pstmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
            }
        }
    }

    public static void product_stock() {
        int productid = Integer.parseInt(JOptionPane.showInputDialog("Enter product ID:"));
        String newstock = JOptionPane.showInputDialog("Enter new stock:");

        Connection conn = con();
        if (conn != null) {
            try {
                String query = "UPDATE product SET stock_quantity = ? WHERE product_id = ?";
                PreparedStatement pstmt = conn.prepareStatement(query);

                pstmt.setString(1, newstock);
                pstmt.setInt(2, productid);

                int rowsUpdated = pstmt.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "product stock updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No product found with the given ID.");
                }

                pstmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
            }
        }
    }

    public static void selectQuery() {
        String[] updateOptions = {"OrderTotalPrice", "OrderDate", "OrderDetails", "OrderPaymentMethod", "ProductPrice", "productQuntity", "CustomerDetails", "Exite"};
        while (true) {
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Choose what to Show:",
                    "Select Options",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    updateOptions,
                    updateOptions[0]
            );

            switch (choice) {
                case 0: 
                    viewTotalPrice();
                    break;
                case 1:
                    viewOrderDate();
                    break;
                case 2: 
                    viewOrderDetails();
                    break;

                case 3: 
                    viewOrderPaymentMethod();
                    break;
                case 4: 
                    viewProductPrice();
                    break;
                case 5: 
                    viewproductQuntity();
                    break;
                case 6: 
                    viewCustomerDetails();
                    break;

                case 7,-1: 
                    return; 
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice!");
            }
        }
    }

    public static void viewTotalPrice() {
        int orderId = Integer.parseInt(JOptionPane.showInputDialog("Enter Order ID:"));

        Connection conn = con();
        if (conn != null) {
            try {
                
                String query = "SELECT Total_Price FROM order WHERE order_id = ?";

                
                PreparedStatement pstmt = conn.prepareStatement(query);

                
                pstmt.setInt(1, orderId);

                
                var resultSet = pstmt.executeQuery();

                if (resultSet.next()) {
                    
                    double totalPrice = resultSet.getDouble("total_price");
                    JOptionPane.showMessageDialog(null, "Total Price for Order ID " + orderId + ": " + totalPrice);
                } else {
                    JOptionPane.showMessageDialog(null, "No order found with the given ID.");
                }

                
                pstmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
            }
        }
    }

    public static void viewOrderDate() {
        int orderId = Integer.parseInt(JOptionPane.showInputDialog("Enter Order ID:"));

        Connection conn = con();
        if (conn != null) {
            try {
               
                String query = "SELECT order_date FROM order WHERE order_id = ?";

               
                PreparedStatement pstmt = conn.prepareStatement(query);

                
                pstmt.setInt(1, orderId);

               
                var resultSet = pstmt.executeQuery();

                if (resultSet.next()) {
                   
                    String order_date = resultSet.getString("order_date");
                    JOptionPane.showMessageDialog(null, "Order date for Order ID " + orderId + ": " + order_date);
                } else {
                    JOptionPane.showMessageDialog(null, "No order found with the given ID.");
                }

               
                pstmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
            }
        }
    }

    public static void viewOrderDetails() {
        int OrderId = Integer.parseInt(JOptionPane.showInputDialog("Enter Order ID:"));

        Connection conn = con();
        if (conn != null) {
            try {
                
                String query = "SELECT order_id,order_date,Total_Price, customer_id, shipping_address FROM order WHERE order_id = ?";

               
                PreparedStatement pstmt = conn.prepareStatement(query);

                
                pstmt.setInt(1, OrderId);

                
                var resultSet = pstmt.executeQuery();

                if (resultSet.next()) {
                   
                    int id = resultSet.getInt("order_id");
                    String date = resultSet.getString("order_date");
                    int totalPrice = resultSet.getInt("Total_Price");
                    String customer_id = resultSet.getString("customer_id");
                    String shipping_address = resultSet.getString("shipping_address");

                   
                    JOptionPane.showMessageDialog(null,
                            "Order Details:\n"
                            + "order_id: " + id + "\n"
                            + "order_date: " + date + "\n"
                            + "Total_Price: " + totalPrice + "\n"
                            + "customer_id: " + customer_id + "\n"
                            + "shipping_address: " + shipping_address);
                } else {
                    JOptionPane.showMessageDialog(null, "No customer found with the given ID.");
                }

                
                pstmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
            }
        }
    }

    public static void viewOrderPaymentMethod() {
        int orderId = Integer.parseInt(JOptionPane.showInputDialog("Enter Order ID:"));

        Connection conn = con();
        if (conn != null) {
            try {
               
                String query = "SELECT payment FROM payment_method WHERE order_id = ?";

                
                PreparedStatement pstmt = conn.prepareStatement(query);

                
                pstmt.setInt(1, orderId);

            
                var resultSet = pstmt.executeQuery();

                if (resultSet.next()) {
                    
                    double totalPrice = resultSet.getDouble("payment_method");
                    JOptionPane.showMessageDialog(null, "payment_method for Order ID " + orderId + ": " + totalPrice);
                } else {
                    JOptionPane.showMessageDialog(null, "No order found with the given ID.");
                }

                
                pstmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
            }
        }
    }

    public static void viewProductPrice() {
        int orderId = Integer.parseInt(JOptionPane.showInputDialog("Enter Product ID:"));

        Connection conn = con();
        if (conn != null) {
            try {
               
                String query = "SELECT price FROM product WHERE product_id = ?";

                
                PreparedStatement pstmt = conn.prepareStatement(query);

              
                pstmt.setInt(1, orderId);

                
                var resultSet = pstmt.executeQuery();

                if (resultSet.next()) {
                    
                    double totalPrice = resultSet.getDouble("ProductPrice");
                    JOptionPane.showMessageDialog(null, "Product Price for Order ID " + orderId + ": " + totalPrice);
                } else {
                    JOptionPane.showMessageDialog(null, "No order found with the given ID.");
                }

                
                pstmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
            }
        }
    }

    public static void viewproductQuntity() {
        int orderId = Integer.parseInt(JOptionPane.showInputDialog("Enter Product ID:"));

        Connection conn = con();
        if (conn != null) {
            try {
                
                String query = "SELECT stock_quantity FROM product WHERE product_id = ?";

                
                PreparedStatement pstmt = conn.prepareStatement(query);

              
                pstmt.setInt(1, orderId);

               
                var resultSet = pstmt.executeQuery();

                if (resultSet.next()) {
                    
                    double totalPrice = resultSet.getDouble("stock_quantity");
                    JOptionPane.showMessageDialog(null, "stock_quantity for Order ID " + orderId + ": " + totalPrice);
                } else {
                    JOptionPane.showMessageDialog(null, "No order found with the given ID.");
                }

                
                pstmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
            }
        }
    }

    public static void viewCustomerDetails() {
        int OrderId = Integer.parseInt(JOptionPane.showInputDialog("Enter Customer ID:"));

        Connection conn = con();
        if (conn != null) {
            try {
                
                String query = "SELECT customer_id,customer_name,Address, phone_number, registar_date FROM customer WHERE customer_id = ?";

                
                PreparedStatement pstmt = conn.prepareStatement(query);

               
                pstmt.setInt(1, OrderId);

               
                var resultSet = pstmt.executeQuery();

                if (resultSet.next()) {
                    
                    String id = resultSet.getString("customer_id");
                    String customer_name = resultSet.getString("customer_name");
                    String Address = resultSet.getString("Address");
                    String phone_number = resultSet.getString("phone_number");
                    String registar_date = resultSet.getString("registar_date");

                    
                    JOptionPane.showMessageDialog(null,
                            "Customer Details:\n"
                            + "customer_id: " + id + "\n"
                            + "customer_name: " + customer_name + "\n"
                            + "Address: " + Address + "\n"
                            + "phone_number: " + phone_number + "\n"
                            + "registar_date: " + registar_date);
                } else {
                    JOptionPane.showMessageDialog(null, "No customer found with the given ID.");
                }

                
                pstmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
            }
        }
    }

    public static void DeleteQuery() {
        String[] updateOptions = {"DeleteCatgory", "DeleteCustomer", "DeleteOrder", "DeletePaymentMethod", "Exite"};
        while (true) {
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Choose what to Show:",
                    "Select Options",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    updateOptions,
                    updateOptions[0]
            );

            switch (choice) {
                case 0: 
                    deleteCategory();
                    break;
                case 1: 
                    DeleteCustomer();
                    break;
                case 2: 
                    DeleteOrder();
                    break;

                case 3: 
                    DeletePaymentMethod();
                    break;

                case 4,-1: 
                    return; 
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice!");
            }
        }
    }

    public static void deleteCategory() {
        
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID of category:"));

        
        Connection conn = con();
        if (conn != null) {
            try {
              
                String query = "DELETE FROM Category WHERE category_id = ?";

                
                PreparedStatement pstmt = conn.prepareStatement(query);

               
                pstmt.setInt(1, id);

              
                int rowsDeleted = pstmt.executeUpdate();

                
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(null, "category deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No row found with the given ID.");
                }

                
                pstmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
            }
        }
    }

    public static void DeleteOrder() {
        
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID of order:"));

        
        Connection conn = con();
        if (conn != null) {
            try {
                
                String query = "DELETE FROM order WHERE order_id = ?";

                
                PreparedStatement pstmt = conn.prepareStatement(query);

                
                pstmt.setInt(1, id);

                
                int rowsDeleted = pstmt.executeUpdate();

                
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(null, "order deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No row found with the given ID.");
                }

                
                pstmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
            }
        }
    }

    public static void DeleteCustomer() {
        
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID of customer:"));

        
        Connection conn = con();
        if (conn != null) {
            try {
                
                String query = "DELETE FROM customer WHERE customer_id = ?";

                
                PreparedStatement pstmt = conn.prepareStatement(query);

                
                pstmt.setInt(1, id);

                
                int rowsDeleted = pstmt.executeUpdate();

                
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(null, "customer deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No row found with the given ID.");
                }

                
                pstmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
            }
        }
    }

    public static void DeletePaymentMethod() {
        
        String name = JOptionPane.showInputDialog("Enter name of PaymentMethod:");

        
        Connection conn = con();
        if (conn != null) {
            try {
                
                String query = "DELETE FROM payment WHERE payment_method = ?";

               
                PreparedStatement pstmt = conn.prepareStatement(query);

                
                pstmt.setString(1, name);

               
                int rowsDeleted = pstmt.executeUpdate();

                
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(null, "payment_method deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No row found with the given name.");
                }

                
                pstmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        String[] options = {"Update Query", "Select Query", "Delete Query", "Exit"};
        while (true) {
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Choose an action:",
                    "Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            switch (choice) {
                case 0: 
                    updateQuery();
                    break;
                case 1: 
                    selectQuery();
                    break;
                case 2: 
                    DeleteQuery();
                    break;
                case 3,-1: 
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice!");
            }
        }
    }
}