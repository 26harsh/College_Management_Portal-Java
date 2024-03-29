/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.portal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Atharva Dhadke
 */
public class Admin_LibraryReturnBook extends javax.swing.JFrame {
    
    //String b_id,b_name,b_author,b_publication,b_edition,student_name,enroll_no,dept,year,issuedate;
    
        String bookid, bookname,studentname,enroll,idate,rdate,fine;
    
    PreparedStatement ps;
     Connection con ;
     ResultSet rs;
 
    DefaultTableModel tblModel;
    
    private int mouseX;
    private int mouseY;
    private Color redColor = new Color(204,51,0); 
   
     

    /**
     * Creates new form Student_ViewBook
     */
    public Admin_LibraryReturnBook() {
        initComponents();
        
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
          table.getTableHeader().setOpaque(false);
          table.getTableHeader().setBackground(new Color(58, 63, 67));
          table.getTableHeader().setForeground(new Color(255,255,255));
//          table.setRowHeight(40)

 
        try
        { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
            String sql = "SELECT * FROM returnedbooks ";
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery ();
             tblModel = (DefaultTableModel)table.getModel();
             tblModel.setRowCount(0);
            while(rs.next())
            {
                bookid=rs.getString("book_id");
                bookname=rs.getString("book_name");
                studentname=rs.getString("student_name");
                enroll=rs.getString("enroll");
                idate=rs.getString("issue");
                rdate=rs.getString("return");
                fine=rs.getString("fine");
                
                  
                     
                    String tbdata[] ={ bookid, bookname,studentname,enroll,idate,rdate,fine};
                    tblModel.addRow(tbdata);       
            } 
        }
        catch(Exception e)
        {
                e.getMessage();
        }      
         
          
     
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tf_searchBook = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbl_viewBook = new javax.swing.JLabel();
        lbl_viewUser = new javax.swing.JLabel();
        lbl_viewIssue = new javax.swing.JLabel();
        lbl_addBook = new javax.swing.JLabel();
        lbl_back = new javax.swing.JLabel();
        lbl_deleteBook = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(122, 125, 128));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Books Returned By Students");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1240, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 1240, 70));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(71, 67, 67));
        jLabel2.setText("Search Returned Book :");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        tf_searchBook.setFont(new java.awt.Font("Tahoma", 0, 33)); // NOI18N
        tf_searchBook.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_searchBookKeyReleased(evt);
            }
        });
        jPanel4.add(tf_searchBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 520, 50));

        jScrollPane1.setBorder(null);

        table.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Book Name", "Student Name", "Enrollment", "Issued  Date", "Returned Date", "Fine Paid"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setFocusable(false);
        table.setGridColor(new java.awt.Color(153, 153, 153));
        table.setRowHeight(35);
        table.setSelectionBackground(new java.awt.Color(153, 153, 153));
        table.setShowVerticalLines(false);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(100);
            table.getColumnModel().getColumn(0).setPreferredWidth(100);
            table.getColumnModel().getColumn(0).setMaxWidth(100);
            table.getColumnModel().getColumn(1).setMinWidth(300);
            table.getColumnModel().getColumn(1).setPreferredWidth(300);
            table.getColumnModel().getColumn(1).setMaxWidth(300);
            table.getColumnModel().getColumn(2).setMinWidth(300);
            table.getColumnModel().getColumn(2).setPreferredWidth(300);
            table.getColumnModel().getColumn(2).setMaxWidth(300);
            table.getColumnModel().getColumn(3).setMinWidth(80);
            table.getColumnModel().getColumn(3).setPreferredWidth(80);
            table.getColumnModel().getColumn(3).setMaxWidth(80);
            table.getColumnModel().getColumn(4).setMinWidth(160);
            table.getColumnModel().getColumn(4).setPreferredWidth(160);
            table.getColumnModel().getColumn(4).setMaxWidth(160);
            table.getColumnModel().getColumn(5).setMinWidth(160);
            table.getColumnModel().getColumn(5).setPreferredWidth(160);
            table.getColumnModel().getColumn(5).setMaxWidth(160);
            table.getColumnModel().getColumn(6).setMinWidth(100);
            table.getColumnModel().getColumn(6).setPreferredWidth(100);
            table.getColumnModel().getColumn(6).setMaxWidth(100);
        }

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 1200, 640));

        jLabel3.setBackground(new java.awt.Color(89, 93, 97));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Search");
        jLabel3.setOpaque(true);
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 40, 140, 50));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 1240, 780));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("—");
        jLabel8.setOpaque(true);
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });

        lblClose.setBackground(new java.awt.Color(255, 255, 255));
        lblClose.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblClose.setForeground(new java.awt.Color(255, 0, 0));
        lblClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClose.setText("X");
        lblClose.setOpaque(true);
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCloseMouseExited(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("University Portal");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 517, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 936, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 50));

        jPanel7.setBackground(new java.awt.Color(58, 63, 67));
        jPanel7.setPreferredSize(new java.awt.Dimension(400, 850));

        jLabel19.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\Java Project Images\\final admin .png")); // NOI18N
        jLabel19.setText("jLabel19");

        jLabel20.setBackground(new java.awt.Color(0, 0, 0));
        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("MR Admin");
        jLabel20.setOpaque(true);

        lbl_viewBook.setBackground(new java.awt.Color(58, 63, 67));
        lbl_viewBook.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbl_viewBook.setForeground(new java.awt.Color(255, 255, 255));
        lbl_viewBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_viewBook.setText("View Books");
        lbl_viewBook.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(74, 81, 86)));
        lbl_viewBook.setOpaque(true);
        lbl_viewBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_viewBookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_viewBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_viewBookMouseExited(evt);
            }
        });

        lbl_viewUser.setBackground(new java.awt.Color(58, 63, 67));
        lbl_viewUser.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbl_viewUser.setForeground(new java.awt.Color(255, 255, 255));
        lbl_viewUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_viewUser.setText("View User");
        lbl_viewUser.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(74, 81, 86)));
        lbl_viewUser.setOpaque(true);
        lbl_viewUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_viewUserMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_viewUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_viewUserMouseExited(evt);
            }
        });

        lbl_viewIssue.setBackground(new java.awt.Color(58, 63, 67));
        lbl_viewIssue.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbl_viewIssue.setForeground(new java.awt.Color(255, 255, 255));
        lbl_viewIssue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_viewIssue.setText("View Issued Books");
        lbl_viewIssue.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(74, 81, 86)));
        lbl_viewIssue.setOpaque(true);
        lbl_viewIssue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_viewIssueMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_viewIssueMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_viewIssueMouseExited(evt);
            }
        });

        lbl_addBook.setBackground(new java.awt.Color(58, 63, 67));
        lbl_addBook.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbl_addBook.setForeground(new java.awt.Color(255, 255, 255));
        lbl_addBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_addBook.setText("Add Book");
        lbl_addBook.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(74, 81, 86)));
        lbl_addBook.setOpaque(true);
        lbl_addBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_addBookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_addBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_addBookMouseExited(evt);
            }
        });

        lbl_back.setBackground(new java.awt.Color(153, 153, 153));
        lbl_back.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbl_back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_back.setText("BACK");
        lbl_back.setOpaque(true);
        lbl_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_backMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_backMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_backMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_backMouseReleased(evt);
            }
        });

        lbl_deleteBook.setBackground(new java.awt.Color(58, 63, 67));
        lbl_deleteBook.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbl_deleteBook.setForeground(new java.awt.Color(255, 255, 255));
        lbl_deleteBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_deleteBook.setText("Delete Book");
        lbl_deleteBook.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(74, 81, 86)));
        lbl_deleteBook.setOpaque(true);
        lbl_deleteBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_deleteBookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_deleteBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_deleteBookMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_viewBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_viewUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(lbl_back, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(124, Short.MAX_VALUE))
            .addComponent(lbl_viewIssue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_addBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_deleteBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(lbl_viewBook, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_viewUser, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_viewIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_addBook, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_deleteBook, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(lbl_back, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 900));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tf_searchBookKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchBookKeyReleased
        // TODO add your handling code here:
         DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
          String search= tf_searchBook.getText();
          
//          String pass= search.substring(0,1).toUpperCase() +search.substring(1);
        
         TableRowSorter<DefaultTableModel> tr = new  TableRowSorter<DefaultTableModel>(tblModel);
         table.setRowSorter(tr);
         tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_tf_searchBookKeyReleased

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:

        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        // TODO add your handling code here:
        jLabel8.setBackground(new Color(229,229,229));
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        // TODO add your handling code here:

        jLabel8.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jLabel8MouseExited

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        int ans = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit","Close",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(ans == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_lblCloseMouseClicked

    private void lblCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseEntered
        // TODO add your handling code here:

        lblClose.setBackground(redColor);
        lblClose.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblCloseMouseEntered

    private void lblCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseExited
        // TODO add your handling code here:
        lblClose.setBackground(Color.WHITE);
        lblClose.setForeground(redColor);
    }//GEN-LAST:event_lblCloseMouseExited

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:

        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - mouseX,y - mouseY);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:

        this.mouseX = evt.getX();
        this.mouseY = evt.getY();

    }//GEN-LAST:event_jPanel1MousePressed

    private void lbl_viewBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_viewBookMouseClicked
        // TODO add your handling code here:
        new Admin_viewBook().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_viewBookMouseClicked

    private void lbl_viewBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_viewBookMouseEntered
        // TODO add your handling code here:
        lbl_viewBook.setBackground(new Color(78, 85, 90));
    }//GEN-LAST:event_lbl_viewBookMouseEntered

    private void lbl_viewBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_viewBookMouseExited
        // TODO add your handling code here:
        lbl_viewBook.setBackground(new Color(58,63,67));
    }//GEN-LAST:event_lbl_viewBookMouseExited

    private void lbl_viewUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_viewUserMouseClicked
        // TODO add your handling code here:
        new Admin_LibraryViewUsers().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_viewUserMouseClicked

    private void lbl_viewUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_viewUserMouseEntered
        // TODO add your handling code here:
        lbl_viewUser.setBackground(new Color(78, 85, 90));
    }//GEN-LAST:event_lbl_viewUserMouseEntered

    private void lbl_viewUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_viewUserMouseExited
        // TODO add your handling code here:
        lbl_viewUser.setBackground(new Color(58,63,67));
    }//GEN-LAST:event_lbl_viewUserMouseExited

    private void lbl_viewIssueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_viewIssueMouseClicked
        // TODO add your handling code here:
        new Admin_LibraryIssuedBooks().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_viewIssueMouseClicked

    private void lbl_viewIssueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_viewIssueMouseEntered
        // TODO add your handling code here:
        lbl_viewIssue.setBackground(new Color(78, 85, 90));
    }//GEN-LAST:event_lbl_viewIssueMouseEntered

    private void lbl_viewIssueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_viewIssueMouseExited
        // TODO add your handling code here:
        lbl_viewIssue.setBackground(new Color(58,63,67));
    }//GEN-LAST:event_lbl_viewIssueMouseExited

    private void lbl_addBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_addBookMouseClicked
        // TODO add your handling code here:

        new AddBook().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_addBookMouseClicked

    private void lbl_addBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_addBookMouseEntered
        // TODO add your handling code here:
        lbl_addBook.setBackground(new Color(78, 85, 90));
    }//GEN-LAST:event_lbl_addBookMouseEntered

    private void lbl_addBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_addBookMouseExited
        // TODO add your handling code here:
        lbl_addBook.setBackground(new Color(58,63,67));
    }//GEN-LAST:event_lbl_addBookMouseExited

    private void lbl_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_backMouseClicked
        // TODO add your handling code here:
        //       new Admin_LibraryDashboard().setVisible(true);
        //       this.dispose();
    }//GEN-LAST:event_lbl_backMouseClicked

    private void lbl_backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_backMouseEntered
        // TODO add your handling code here:

        lbl_back.setBackground(new Color(255,255,255));
        lbl_back.setLocation(lbl_back.getLocation().x, lbl_back.getLocation().y-4);
    }//GEN-LAST:event_lbl_backMouseEntered

    private void lbl_backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_backMouseExited
        // TODO add your handling code here:
        lbl_back.setBackground(new Color(153,153,153));
        lbl_back.setLocation(lbl_back.getLocation().x, lbl_back.getLocation().y+4);
    }//GEN-LAST:event_lbl_backMouseExited

    private void lbl_backMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_backMousePressed
        // TODO add your handling code here:
        lbl_back.setLocation(lbl_back.getLocation().x, lbl_back.getLocation().y-4);
    }//GEN-LAST:event_lbl_backMousePressed

    private void lbl_backMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_backMouseReleased
        // TODO add your handling code here:
        lbl_back.setLocation(lbl_back.getLocation().x, lbl_back.getLocation().y+4);
        new Admin_LibraryDashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_backMouseReleased

    private void lbl_deleteBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_deleteBookMouseClicked
        // TODO add your handling code here:
        new DeleteBook().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_deleteBookMouseClicked

    private void lbl_deleteBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_deleteBookMouseEntered
        // TODO add your handling code here:
        lbl_deleteBook.setBackground(new Color(78, 85, 90));
    }//GEN-LAST:event_lbl_deleteBookMouseEntered

    private void lbl_deleteBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_deleteBookMouseExited
        // TODO add your handling code here:
        lbl_deleteBook.setBackground(new Color(58,63,67));
    }//GEN-LAST:event_lbl_deleteBookMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin_LibraryReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_LibraryReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_LibraryReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_LibraryReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_LibraryReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lbl_addBook;
    private javax.swing.JLabel lbl_back;
    private javax.swing.JLabel lbl_deleteBook;
    private javax.swing.JLabel lbl_viewBook;
    private javax.swing.JLabel lbl_viewIssue;
    private javax.swing.JLabel lbl_viewUser;
    private javax.swing.JTable table;
    private javax.swing.JTextField tf_searchBook;
    // End of variables declaration//GEN-END:variables
}
