/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.portal;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.print.PrinterException;
import javax.swing.JPanel;


/**
 *
 * @author Atharva
 */
public class Fees_Management extends javax.swing.JFrame {
    
    String ret_fname, ret_lname, ret_email, ret_phoneNo, ret_gender, ret_bloodGroup, ret_address ;
    String ret_fatherName, ret_motherName, ret_fatherNO,ret_motherNo, ret_fatherOcc, ret_motherOcc;
    String ret_dept,ret_year, ret_enroll, ret_percentage, ret_username ;
    byte byteImage[];
    
    String paymentMode,creditNo,creditName,creditCvv,creditBank;
    String debitNo,debitName,debitCvv,debitBank;
    String dd,ddAccNo,ddIFSC,ddBank;
    String cheaqueNo,cheaqueAccNo,cheaqueIFSC,cheaqueBank;
    String re_tution,re_development,re_insurance,re_exam,re_id,re_cmd,re_formFee,re_total,bdate,trc_id;
    int transactionId;
    
    private int mouseX;
    private int mouseY;
    private Color redColor = new Color(204,51,0); 
    
   
    
    
    
    //    *****************************************//
    
    String FYCO_tution = "80,357";
    String FYCO_development = "9,643";
    String FYCO_insurance = "454";
    String FYCO_icard = "175";
    String FYCO_cautionMoneyDeposit = "2,000";
    String FYCO_exam = "2,500";
    String FYCO_form = "500";
    String FYCO_total = "95,629";
    
    String SYCO_tution = "65,179";
    String SYCO_development = "7,821";
    String SYCO_insurance = "200";
    String SYCO_icard = "0";
    String SYCO_cautionMoneyDeposit = "2,000";
    String SYCO_exam = "2,500";
    String SYCO_form = "500";
    String SYCO_total = "78,200";
    
    String TYCO_tution = "63,179";
    String TYCO_development = "7,821";
    String TYCO_insurance = "200";
    String TYCO_icard = "0";
    String TYCO_cautionMoneyDeposit = "2,000";
    String TYCO_exam = "2,500";
    String TYCO_form = "500";
    String TYCO_total = "76,200";
   
//    *****************************************//
    
    String FYCE_tution = "80,357";
    String FYCE_development = "9,643";
    String FYCE_insurance = "454";
    String FYCE_icard = "175";
    String FYCE_cautionMoneyDeposit = "2,000";
    String FYCE_exam = "2,500";
    String FYCE_form = "500";
    String FYCE_total = "95,629 civil fy";
    
    String SYCE_tution = "65,179";
    String SYCE_development = "7,821";
    String SYCE_insurance = "200";
    String SYCE_icard = "0";
    String SYCE_cautionMoneyDeposit = "2,000";
    String SYCE_exam = "2,500";
    String SYCE_form = "500";
    String SYCE_total = "78,200 civil sy";
    
    String TYCE_tution = "63,179";
    String TYCE_development = "7,821";
    String TYCE_insurance = "200";
    String TYCE_icard = "0";
    String TYCE_cautionMoneyDeposit = "2,000";
    String TYCE_exam = "2,500";
    String TYCE_form = "500";
    String TYCE_total = "76,200 civil ty";
    
 //    *****************************************//
    
    String FYME_tution = "80,357";
    String FYME_development = "9,643";
    String FYME_insurance = "454";
    String FYME_icard = "175";
    String FYME_cautionMoneyDeposit = "2,000";
    String FYME_exam = "2,500";
    String FYME_form = "500";
    String FYME_total = "95,629 mech fy";
    
    String SYME_tution = "65,179";
    String SYME_development = "7,821";
    String SYME_insurance = "200";
    String SYME_icard = "0";
    String SYME_cautionMoneyDeposit = "2,000";
    String SYME_exam = "2,500";
    String SYME_form = "500";
    String SYME_total = "78,200 mech sy";
    
    String TYME_tution = "63,179";
    String TYME_development = "7,821";
    String TYME_insurance = "200";
    String TYME_icard = "0";
    String TYME_cautionMoneyDeposit = "2,000";
    String TYME_exam = "2,500";
    String TYME_form = "500";
    String TYME_total = "76,200 mech ty";
    
    
    //    *****************************************//
    String FYEE_tution = "80,357";
    String FYEE_development = "9,643";
    String FYEE_insurance = "454";
    String FYEE_icard = "175";
    String FYEE_cautionMoneyDeposit = "2,000";
    String FYEE_exam = "2,500";
    String FYEE_form = "500";
    String FYEE_total = "95,629 electric fy";
    
    String SYEE_tution = "65,179";
    String SYEE_development = "7,821";
    String SYEE_insurance = "200";
    String SYEE_icard = "0";
    String SYEE_cautionMoneyDeposit = "2,000";
    String SYEE_exam = "2,500";
    String SYEE_form = "500";
    String SYEE_total = "78,200 electric sy";
    
    String TYEE_tution = "63,179";
    String TYEE_development = "7,821";
    String TYEE_insurance = "200";
    String TYEE_icard = "0";
    String TYEE_cautionMoneyDeposit = "2,000";
    String TYEE_exam = "2,500";
    String TYEE_form = "500";
    String TYEE_total = "76,200 electric ty";
    
   // *****************************************************
    
    String FYIE_tution = "80,357";
    String FYIE_development = "9,643";
    String FYIE_insurance = "454";
    String FYIE_icard = "175";
    String FYIE_cautionMoneyDeposit = "2,000";
    String FYIE_exam = "2,500";
    String FYIE_form = "500";
    String FYIE_total = "95,629 indus fy";
    
    String SYIE_tution = "65,179";
    String SYIE_development = "7,821";
    String SYIE_insurance = "200";
    String SYIE_icard = "0";
    String SYIE_cautionMoneyDeposit = "2,000";
    String SYIE_exam = "2,500";
    String SYIE_form = "500";
    String SYIE_total = "78,200 indus sy";
    
    String TYIE_tution = "63,179";
    String TYIE_development = "7,821";
    String TYIE_insurance = "200";
    String TYIE_icard = "0";
    String TYIE_cautionMoneyDeposit = "2,000";
    String TYIE_exam = "2,500";
    String TYIE_form = "500";
    String TYIE_total = "76,200 indus ty";
    
    /**
     * Creates new form Fees_Management
     */
    
    
    
    public Fees_Management() {
        initComponents();
//        btn_feesReceipt.setEnabled(false);
       
        pnl_Payment.setVisible(false);
        pnl_receipt.setVisible(false);
        pnl_FeesNotPaid.setVisible(false);
        pnl_FeesStructure.setVisible(true);
        pnl_FeesStructure.setBounds(401,173,1200,680);
         btn_print.setVisible(false);
        
        pnl_creditCard.setVisible(true);
        pnl_debitCard.setVisible(false);
        pnl_cheaque.setVisible(false);
        pnl_demandDraft.setVisible(false);
        pnl_bankTransfer.setVisible(false);
        
        try
        {
            String test = Student_Login.username;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            PreparedStatement ps;
            
            String sql = "SELECT * FROM studentdb WHERE username='" + test + "'";
            ps = con.prepareStatement(sql);
            
          
            ResultSet rs = ps.executeQuery ();
            while(rs.next())
            {
            ret_fname  = rs.getString("FIRST_NAME");
            ret_lname = rs.getString("LAST_NAME");
            ret_email = rs.getString("Email");
            ret_phoneNo = rs.getString("PhoneNo");
            ret_gender  = rs.getString("Gender");
            ret_bloodGroup    = rs.getString("BloodGroup");     
            ret_address       = rs.getString("Address");  
            ret_fatherName    = rs.getString("FatherName");   
            ret_motherName  =rs.getString("MotherName");                   
            ret_fatherNO     =rs.getString("FatherMobileNo");
            ret_motherNo   =rs.getString("MotherMobileNo");
            ret_fatherOcc =rs.getString("FatherOccupation");
            ret_motherOcc =rs.getString("MotherOccupation");
            ret_dept    =rs.getString("Department");
            ret_year    =rs.getString("Year");
            ret_enroll  =rs.getString("EnrollmentNo");
            ret_percentage  =rs.getString("Percentage");
            ret_username    =rs.getString("username");
            
            byteImage = rs.getBytes("Image");
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(byteImage));
            ImageIcon icon = new ImageIcon(image);
            lbl_photo.setIcon(icon); 
            
          }
        }
        catch(Exception e)
        {
            System.out.println("Caught Exception");
            e.getMessage();
        }
        
        
        lbl_name.setText(ret_fname +" "+ret_lname);
        lbl_dept.setText(ret_dept);
        lbl_year.setText(ret_year);
        
        
       
        try{
        if(ret_dept.equals("Computer") && ret_year.equals("First Year")){
        System.out.println("First condition working fine");
        lbl_tution.setText(FYCO_tution);
        lbl_development.setText(FYCO_development);
        lbl_insurance.setText(FYCO_insurance);
        lbl_exam.setText(FYCO_exam);
        lbl_id.setText(FYCO_icard);
        lbl_cmd.setText(FYCO_cautionMoneyDeposit);
        lbl_formfee.setText(FYCO_form);
        lbl_total.setText(FYCO_total);
 
        }
        
        
        else if(ret_dept.equals("Computer") && ret_year.equals("Second Year")){
        System.out.println("Second condition working fine");
        lbl_tution.setText(SYCO_tution);
        lbl_development.setText(SYCO_development);
        lbl_insurance.setText(SYCO_insurance);
        lbl_exam.setText(SYCO_exam);
        lbl_id.setText(SYCO_icard);
        lbl_cmd.setText(SYCO_cautionMoneyDeposit);
        lbl_formfee.setText(SYCO_form);
        lbl_total.setText(SYCO_total);
          
        }
        
        else if(ret_dept.equals("Computer") && ret_year.equals("Third Year")){
        System.out.println("Third condition working fine");
        lbl_tution.setText(TYCO_tution);
        lbl_development.setText(TYCO_development);
        lbl_insurance.setText(TYCO_insurance);
        lbl_exam.setText(TYCO_exam);
        lbl_id.setText(TYCO_icard);
        lbl_cmd.setText(TYCO_cautionMoneyDeposit);
        lbl_formfee.setText(TYCO_form);
        lbl_total.setText(TYCO_total);

        }
        
       // ****************Civil*********************
        else if(ret_dept.equals("Civil") && ret_year.equals("First Year")){
        System.out.println("First condition working fine");
        lbl_tution.setText(FYCE_tution);
        lbl_development.setText(FYCE_development);
        lbl_insurance.setText(FYCE_insurance);
        lbl_exam.setText(FYCE_exam);
        lbl_id.setText(FYCE_icard);
        lbl_cmd.setText(FYCE_cautionMoneyDeposit);
        lbl_formfee.setText(FYCE_form);
        lbl_total.setText(FYCE_total);

        }
        
        
        else if(ret_dept.equals("Civil") && ret_year.equals("Second Year")){
        System.out.println("Second condition working fine");
        lbl_tution.setText(SYCE_tution);
        lbl_development.setText(SYCE_development);
        lbl_insurance.setText(SYCE_insurance);
        lbl_exam.setText(SYCE_exam);
        lbl_id.setText(SYCE_icard);
        lbl_cmd.setText(SYCE_cautionMoneyDeposit);
        lbl_formfee.setText(SYCE_form);
        lbl_total.setText(SYCE_total);
        }
        
        else if(ret_dept.equals("Civil") && ret_year.equals("Third Year")){
        System.out.println("Third condition working fine");
        lbl_tution.setText(TYCE_tution);
        lbl_development.setText(TYCE_development);
        lbl_insurance.setText(TYCE_insurance);
        lbl_exam.setText(TYCE_exam);
        lbl_id.setText(TYCE_icard);
        lbl_cmd.setText(TYCE_cautionMoneyDeposit);
        lbl_formfee.setText(TYCE_form);
        lbl_total.setText(TYCE_total);
        }
       
       // ******************Mechanical*****************************
        
        else if(ret_dept.equals("Mechanical") && ret_year.equals("First Year")){
        System.out.println("First condition working fine");
        lbl_tution.setText(FYME_tution);
        lbl_development.setText(FYME_development);
        lbl_insurance.setText(FYME_insurance);
        lbl_exam.setText(FYME_exam);
        lbl_id.setText(FYME_icard);
        lbl_cmd.setText(FYME_cautionMoneyDeposit);
        lbl_formfee.setText(FYME_form);
        lbl_total.setText(FYME_total);
        }
        
        
        else if(ret_dept.equals("Mechanical") && ret_year.equals("Second Year")){
        System.out.println("Second condition working fine");
        lbl_tution.setText(SYME_tution);
        lbl_development.setText(SYME_development);
        lbl_insurance.setText(SYME_insurance);
        lbl_exam.setText(SYME_exam);
        lbl_id.setText(SYME_icard);
        lbl_cmd.setText(SYME_cautionMoneyDeposit);
        lbl_formfee.setText(SYME_form);
        lbl_total.setText(SYME_total);
        }
        
        else if(ret_dept.equals("Mechanical") && ret_year.equals("Third Year")){
        System.out.println("Third condition working fine");
        lbl_tution.setText(TYME_tution);
        lbl_development.setText(TYME_development);
        lbl_insurance.setText(TYME_insurance);
        lbl_exam.setText(TYME_exam);
        lbl_id.setText(TYME_icard);
        lbl_cmd.setText(TYME_cautionMoneyDeposit);
        lbl_formfee.setText(TYME_form);
        lbl_total.setText(TYME_total);
        }
         //*****************Electrical*****************************
        else if(ret_dept.equals("Electrical") && ret_year.equals("First Year")){
        System.out.println("First condition working fine");
        lbl_tution.setText(FYEE_tution);
        lbl_development.setText(FYEE_development);
        lbl_insurance.setText(FYEE_insurance);
        lbl_exam.setText(FYEE_exam);
        lbl_id.setText(FYEE_icard);
        lbl_cmd.setText(FYEE_cautionMoneyDeposit);
        lbl_formfee.setText(FYEE_form);
        lbl_total.setText(FYEE_total);
        }
        
        
        else if(ret_dept.equals("Electrical") && ret_year.equals("Second Year")){
        System.out.println("Second condition working fine");
        lbl_tution.setText(SYEE_tution);
        lbl_development.setText(SYEE_development);
        lbl_insurance.setText(SYEE_insurance);
        lbl_exam.setText(SYEE_exam);
        lbl_id.setText(SYEE_icard);
        lbl_cmd.setText(SYEE_cautionMoneyDeposit);
        lbl_formfee.setText(SYEE_form);
        lbl_total.setText(SYEE_total);
        }
        
        else if(ret_dept.equals("Electrical") && ret_year.equals("Third Year")){
        System.out.println("Third condition working fine");
        lbl_tution.setText(TYEE_tution);
        lbl_development.setText(TYEE_development);
        lbl_insurance.setText(TYEE_insurance);
        lbl_exam.setText(TYEE_exam);
        lbl_id.setText(TYEE_icard);
        lbl_cmd.setText(TYEE_cautionMoneyDeposit);
        lbl_formfee.setText(TYEE_form);
        lbl_total.setText(TYEE_total);
        }
        
        else{
            System.out.println("Nothing working");
        }
           
       
        }
        catch(Exception e){
            e.getMessage();
        } 
        
        Random random = new Random();
                int id =random.nextInt(10000);
                transactionId= id*7;
                trc_id= String.valueOf(transactionId);
                System.out.println(trc_id);
                
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btn_print = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_feeStructure = new javax.swing.JButton();
        btn_paymentDetails = new javax.swing.JButton();
        btn_feesReceipt = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        pnl_Payment = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btn_makePayment = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        pnl_paymentInformation = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cmb_paymentMode = new javax.swing.JComboBox<>();
        pnl_creditCard = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        tf_creditCardNo = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        tf_creditCardName = new javax.swing.JTextField();
        tf_creditCvv = new javax.swing.JPasswordField();
        jLabel23 = new javax.swing.JLabel();
        cmb_creditBank = new javax.swing.JComboBox<>();
        pnl_debitCard = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        tf_debitCardNo = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        tf__debit_nameOnCard = new javax.swing.JTextField();
        tf_debitCvv = new javax.swing.JPasswordField();
        jLabel29 = new javax.swing.JLabel();
        cmb_debitBank = new javax.swing.JComboBox<>();
        pnl_cheaque = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        tf_cheaqueNo = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        tf_cheaque_AccNo = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        tf_cheaque_IFSC = new javax.swing.JTextField();
        cmb_cheaque_bank = new javax.swing.JComboBox<>();
        pnl_demandDraft = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        tf_dd_draft = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        tf_dd_AccNo = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        tf_dd_IFSC = new javax.swing.JTextField();
        cmb_dd_bank = new javax.swing.JComboBox<>();
        pnl_bankTransfer = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        tf_bank_transfer = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jComboBox5 = new javax.swing.JComboBox<>();
        pnl_FeesStructure = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_tution = new javax.swing.JLabel();
        lbl_development = new javax.swing.JLabel();
        lbl_insurance = new javax.swing.JLabel();
        lbl_exam = new javax.swing.JLabel();
        lbl_id = new javax.swing.JLabel();
        lbl_cmd = new javax.swing.JLabel();
        lbl_formfee = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_photo = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbl_name = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbl_dept = new javax.swing.JLabel();
        lbl_year = new javax.swing.JLabel();
        pnl_FeesNotPaid = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        pnl_receipt = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        rec_date = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        lbl_r_development = new javax.swing.JLabel();
        lbl_r_insurance = new javax.swing.JLabel();
        lbl_r_id = new javax.swing.JLabel();
        lbl_r_exam = new javax.swing.JLabel();
        lbl_r_formFee = new javax.swing.JLabel();
        lbl_r_moneyDeposit = new javax.swing.JLabel();
        lbl_r_total = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        lbl_r_name = new javax.swing.JLabel();
        lbl_r_enroll = new javax.swing.JLabel();
        lbl_r_course = new javax.swing.JLabel();
        lbl_r_class = new javax.swing.JLabel();
        lbl_r_voucher = new javax.swing.JLabel();
        lbl_r_trans = new javax.swing.JLabel();
        lbl_r_tution = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        rec_paymentMode = new javax.swing.JLabel();
        rec_bankName = new javax.swing.JLabel();
        rec_amount = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(83, 165, 221));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 630));

        btn_print.setText("Print");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(btn_print, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(818, Short.MAX_VALUE)
                .addComponent(btn_print, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 900));

        jPanel3.setBackground(new java.awt.Color(145, 200, 247));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 42)); // NOI18N
        jLabel1.setText("Fees Management");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 410, 60));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 1200, 70));

        btn_feeStructure.setBackground(new java.awt.Color(255, 255, 255));
        btn_feeStructure.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_feeStructure.setText("Fee Structure");
        btn_feeStructure.setBorder(null);
        btn_feeStructure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_feeStructureActionPerformed(evt);
            }
        });
        getContentPane().add(btn_feeStructure, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 400, 60));

        btn_paymentDetails.setBackground(new java.awt.Color(255, 255, 255));
        btn_paymentDetails.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_paymentDetails.setText("View Payment Details");
        btn_paymentDetails.setBorder(null);
        btn_paymentDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_paymentDetailsActionPerformed(evt);
            }
        });
        getContentPane().add(btn_paymentDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 140, 400, 60));

        btn_feesReceipt.setBackground(new java.awt.Color(255, 255, 255));
        btn_feesReceipt.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_feesReceipt.setText("Fee Receipt");
        btn_feesReceipt.setBorder(null);
        btn_feesReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_feesReceiptActionPerformed(evt);
            }
        });
        getContentPane().add(btn_feesReceipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 140, 400, 60));

        pnl_Payment.setBackground(new java.awt.Color(145, 200, 247));
        pnl_Payment.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel2.setText("PAYMENT DETAILS");
        pnl_Payment.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 430, 50));
        pnl_Payment.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 180, 300, 40));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel17.setText("Payment Amount :");
        pnl_Payment.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 240, 40));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel18.setText("Payment Date :");
        pnl_Payment.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, 200, 40));

        btn_makePayment.setBackground(new java.awt.Color(117, 228, 224));
        btn_makePayment.setText("Make Payment");
        btn_makePayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_makePaymentActionPerformed(evt);
            }
        });
        pnl_Payment.add(btn_makePayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 640, 200, 40));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        pnl_Payment.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 166, 260, 40));

        pnl_paymentInformation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel13.setText("Payment Information");
        pnl_paymentInformation.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 410, 60));

        pnl_Payment.add(pnl_paymentInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1200, 60));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel16.setText("Mode of Payments :");
        pnl_Payment.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 240, 40));

        cmb_paymentMode.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmb_paymentMode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Credit Card", "Debit Card", "Cheaque", "Demand Draft" }));
        cmb_paymentMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_paymentModeActionPerformed(evt);
            }
        });
        pnl_Payment.add(cmb_paymentMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 150, 40));

        pnl_creditCard.setBackground(new java.awt.Color(145, 200, 247));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel20.setText("Credit Card No :");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel21.setText("Name on card :");

        tf_creditCardNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_creditCardNoActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel22.setText("CVV No :");

        tf_creditCardName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_creditCardNameActionPerformed(evt);
            }
        });

        tf_creditCvv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_creditCvvActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel23.setText("Bank Name :");

        cmb_creditBank.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmb_creditBank.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Allahabad Bank", "Andhra Bank", "Axis Bank", "Bank of Bahrain and Kuwait", "Bank of Baroda - Corporate Banking", "Bank of Baroda - Retail Banking", "Bank of India", "Bank of Maharashtra", "Canara Bank", "Central Bank of India", "City Union Bank", "Corporation Bank", "Deutsche Bank", "Development Credit Bank", "Dhanlaxmi Bank", "Federal Bank", "ICICI Bank", "IDBI Bank", "Indian Bank", "Indian Overseas Bank", "IndusInd Bank", "ING Vysya Bank", "Jammu and Kashmir Bank", "Karnataka Bank Ltd", "Karur Vysya Bank", "Kotak Bank", "Laxmi Vilas Bank", "Oriental Bank of Commerce", "Punjab National Bank - Corporate Banking", "Punjab National Bank - Retail Banking", "Punjab & Sind Bank", "Shamrao Vitthal Co-operative Bank", "South Indian Bank", "State Bank of Bikaner & Jaipur", "State Bank of Hyderabad", "State Bank of India", "State Bank of Mysore", "State Bank of Patiala", "State Bank of Travancore", "Syndicate Bank", "Tamilnad Mercantile Bank Ltd.", "UCO Bank", "Union Bank of India", "United Bank of India", "Vijaya Bank", "Yes Bank Ltd" }));

        javax.swing.GroupLayout pnl_creditCardLayout = new javax.swing.GroupLayout(pnl_creditCard);
        pnl_creditCard.setLayout(pnl_creditCardLayout);
        pnl_creditCardLayout.setHorizontalGroup(
            pnl_creditCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_creditCardLayout.createSequentialGroup()
                .addGroup(pnl_creditCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_creditCardLayout.createSequentialGroup()
                        .addGroup(pnl_creditCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_creditCardLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_creditCardLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnl_creditCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel23))
                                .addGap(24, 24, 24)))
                        .addGroup(pnl_creditCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tf_creditCardName, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                            .addComponent(tf_creditCvv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_creditBank, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_creditCardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(tf_creditCardNo, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnl_creditCardLayout.setVerticalGroup(
            pnl_creditCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_creditCardLayout.createSequentialGroup()
                .addContainerGap(275, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addContainerGap())
            .addGroup(pnl_creditCardLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(pnl_creditCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_creditCardNo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(pnl_creditCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_creditCardName, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pnl_creditCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(cmb_creditBank))
                .addGap(18, 18, 18)
                .addGroup(pnl_creditCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_creditCvv, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnl_Payment.add(pnl_creditCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 1200, 340));

        pnl_debitCard.setBackground(new java.awt.Color(145, 200, 247));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel26.setText("Debit Card No :");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel27.setText("Name on card :");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel28.setText("CVV No :");

        tf_debitCvv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_debitCvvActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel29.setText("Bank Name :");

        cmb_debitBank.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmb_debitBank.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Allahabad Bank", "Andhra Bank", "Axis Bank", "Bank of Bahrain and Kuwait", "Bank of Baroda - Corporate Banking", "Bank of Baroda - Retail Banking", "Bank of India", "Bank of Maharashtra", "Canara Bank", "Central Bank of India", "City Union Bank", "Corporation Bank", "Deutsche Bank", "Development Credit Bank", "Dhanlaxmi Bank", "Federal Bank", "ICICI Bank", "IDBI Bank", "Indian Bank", "Indian Overseas Bank", "IndusInd Bank", "ING Vysya Bank", "Jammu and Kashmir Bank", "Karnataka Bank Ltd", "Karur Vysya Bank", "Kotak Bank", "Laxmi Vilas Bank", "Oriental Bank of Commerce", "Punjab National Bank - Corporate Banking", "Punjab National Bank - Retail Banking", "Punjab & Sind Bank", "Shamrao Vitthal Co-operative Bank", "South Indian Bank", "State Bank of Bikaner & Jaipur", "State Bank of Hyderabad", "State Bank of India", "State Bank of Mysore", "State Bank of Patiala", "State Bank of Travancore", "Syndicate Bank", "Tamilnad Mercantile Bank Ltd.", "UCO Bank", "Union Bank of India", "United Bank of India", "Vijaya Bank", "Yes Bank Ltd" }));

        javax.swing.GroupLayout pnl_debitCardLayout = new javax.swing.GroupLayout(pnl_debitCard);
        pnl_debitCard.setLayout(pnl_debitCardLayout);
        pnl_debitCardLayout.setHorizontalGroup(
            pnl_debitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_debitCardLayout.createSequentialGroup()
                .addGroup(pnl_debitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_debitCardLayout.createSequentialGroup()
                        .addGroup(pnl_debitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_debitCardLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_debitCardLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnl_debitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel29))
                                .addGap(24, 24, 24)))
                        .addGroup(pnl_debitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf__debit_nameOnCard, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_debitCvv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_debitBank, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_debitCardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tf_debitCardNo, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnl_debitCardLayout.setVerticalGroup(
            pnl_debitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_debitCardLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addContainerGap())
            .addGroup(pnl_debitCardLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(pnl_debitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_debitCardLayout.createSequentialGroup()
                        .addGroup(pnl_debitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_debitCardNo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(pnl_debitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf__debit_nameOnCard, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60))
                    .addGroup(pnl_debitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmb_debitBank, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(pnl_debitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_debitCvv, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnl_Payment.add(pnl_debitCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 1200, 340));

        pnl_cheaque.setBackground(new java.awt.Color(145, 200, 247));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel31.setText("Cheaque No :");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel32.setText("Account No :");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel33.setText("Bank Name :");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel34.setText("IFSC code :");

        cmb_cheaque_bank.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmb_cheaque_bank.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Allahabad Bank", "Andhra Bank", "Axis Bank", "Bank of Bahrain and Kuwait", "Bank of Baroda - Corporate Banking", "Bank of Baroda - Retail Banking", "Bank of India", "Bank of Maharashtra", "Canara Bank", "Central Bank of India", "City Union Bank", "Corporation Bank", "Deutsche Bank", "Development Credit Bank", "Dhanlaxmi Bank", "Federal Bank", "ICICI Bank", "IDBI Bank", "Indian Bank", "Indian Overseas Bank", "IndusInd Bank", "ING Vysya Bank", "Jammu and Kashmir Bank", "Karnataka Bank Ltd", "Karur Vysya Bank", "Kotak Bank", "Laxmi Vilas Bank", "Oriental Bank of Commerce", "Punjab National Bank - Corporate Banking", "Punjab National Bank - Retail Banking", "Punjab & Sind Bank", "Shamrao Vitthal Co-operative Bank", "South Indian Bank", "State Bank of Bikaner & Jaipur", "State Bank of Hyderabad", "State Bank of India", "State Bank of Mysore", "State Bank of Patiala", "State Bank of Travancore", "Syndicate Bank", "Tamilnad Mercantile Bank Ltd.", "UCO Bank", "Union Bank of India", "United Bank of India", "Vijaya Bank", "Yes Bank Ltd" }));

        javax.swing.GroupLayout pnl_cheaqueLayout = new javax.swing.GroupLayout(pnl_cheaque);
        pnl_cheaque.setLayout(pnl_cheaqueLayout);
        pnl_cheaqueLayout.setHorizontalGroup(
            pnl_cheaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_cheaqueLayout.createSequentialGroup()
                .addGroup(pnl_cheaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_cheaqueLayout.createSequentialGroup()
                        .addGroup(pnl_cheaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_cheaqueLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(pnl_cheaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnl_cheaqueLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_cheaqueLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(pnl_cheaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_cheaque_AccNo, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_cheaque_IFSC, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_cheaque_bank, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_cheaqueLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel31)
                        .addGap(26, 26, 26)
                        .addComponent(tf_cheaqueNo, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnl_cheaqueLayout.setVerticalGroup(
            pnl_cheaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_cheaqueLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(pnl_cheaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_cheaqueNo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pnl_cheaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_cheaque_AccNo, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnl_cheaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_cheaque_IFSC, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(pnl_cheaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_cheaque_bank, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 49, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_cheaqueLayout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jLabel30)
                .addGap(54, 54, 54))
        );

        pnl_Payment.add(pnl_cheaque, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 1200, 340));

        pnl_demandDraft.setBackground(new java.awt.Color(145, 200, 247));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel36.setText("Demand Draft :");

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel37.setText("Account No :");

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel38.setText("Bank Name :");

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel39.setText("IFSC code :");

        cmb_dd_bank.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmb_dd_bank.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Allahabad Bank", "Andhra Bank", "Axis Bank", "Bank of Bahrain and Kuwait", "Bank of Baroda - Corporate Banking", "Bank of Baroda - Retail Banking", "Bank of India", "Bank of Maharashtra", "Canara Bank", "Central Bank of India", "City Union Bank", "Corporation Bank", "Deutsche Bank", "Development Credit Bank", "Dhanlaxmi Bank", "Federal Bank", "ICICI Bank", "IDBI Bank", "Indian Bank", "Indian Overseas Bank", "IndusInd Bank", "ING Vysya Bank", "Jammu and Kashmir Bank", "Karnataka Bank Ltd", "Karur Vysya Bank", "Kotak Bank", "Laxmi Vilas Bank", "Oriental Bank of Commerce", "Punjab National Bank - Corporate Banking", "Punjab National Bank - Retail Banking", "Punjab & Sind Bank", "Shamrao Vitthal Co-operative Bank", "South Indian Bank", "State Bank of Bikaner & Jaipur", "State Bank of Hyderabad", "State Bank of India", "State Bank of Mysore", "State Bank of Patiala", "State Bank of Travancore", "Syndicate Bank", "Tamilnad Mercantile Bank Ltd.", "UCO Bank", "Union Bank of India", "United Bank of India", "Vijaya Bank", "Yes Bank Ltd" }));

        javax.swing.GroupLayout pnl_demandDraftLayout = new javax.swing.GroupLayout(pnl_demandDraft);
        pnl_demandDraft.setLayout(pnl_demandDraftLayout);
        pnl_demandDraftLayout.setHorizontalGroup(
            pnl_demandDraftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_demandDraftLayout.createSequentialGroup()
                .addGroup(pnl_demandDraftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_demandDraftLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel36)
                        .addGap(18, 18, 18)
                        .addComponent(tf_dd_draft, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_demandDraftLayout.createSequentialGroup()
                        .addGroup(pnl_demandDraftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_demandDraftLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(pnl_demandDraftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnl_demandDraftLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_demandDraftLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(pnl_demandDraftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tf_dd_AccNo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                            .addComponent(tf_dd_IFSC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                            .addComponent(cmb_dd_bank, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnl_demandDraftLayout.setVerticalGroup(
            pnl_demandDraftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_demandDraftLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(pnl_demandDraftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_dd_draft, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnl_demandDraftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_dd_AccNo, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnl_demandDraftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_dd_IFSC, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(pnl_demandDraftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_dd_bank, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 48, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_demandDraftLayout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jLabel35)
                .addGap(54, 54, 54))
        );

        pnl_Payment.add(pnl_demandDraft, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 1200, 340));

        pnl_bankTransfer.setBackground(new java.awt.Color(145, 200, 247));

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel41.setText("Bank Transfer :");

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel42.setText("Account No :");

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel43.setText("Bank Name :");

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel44.setText("IFSC code :");

        jComboBox5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Allahabad Bank", "Andhra Bank", "Axis Bank", "Bank of Bahrain and Kuwait", "Bank of Baroda - Corporate Banking", "Bank of Baroda - Retail Banking", "Bank of India", "Bank of Maharashtra", "Canara Bank", "Central Bank of India", "City Union Bank", "Corporation Bank", "Deutsche Bank", "Development Credit Bank", "Dhanlaxmi Bank", "Federal Bank", "ICICI Bank", "IDBI Bank", "Indian Bank", "Indian Overseas Bank", "IndusInd Bank", "ING Vysya Bank", "Jammu and Kashmir Bank", "Karnataka Bank Ltd", "Karur Vysya Bank", "Kotak Bank", "Laxmi Vilas Bank", "Oriental Bank of Commerce", "Punjab National Bank - Corporate Banking", "Punjab National Bank - Retail Banking", "Punjab & Sind Bank", "Shamrao Vitthal Co-operative Bank", "South Indian Bank", "State Bank of Bikaner & Jaipur", "State Bank of Hyderabad", "State Bank of India", "State Bank of Mysore", "State Bank of Patiala", "State Bank of Travancore", "Syndicate Bank", "Tamilnad Mercantile Bank Ltd.", "UCO Bank", "Union Bank of India", "United Bank of India", "Vijaya Bank", "Yes Bank Ltd" }));

        javax.swing.GroupLayout pnl_bankTransferLayout = new javax.swing.GroupLayout(pnl_bankTransfer);
        pnl_bankTransfer.setLayout(pnl_bankTransferLayout);
        pnl_bankTransferLayout.setHorizontalGroup(
            pnl_bankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_bankTransferLayout.createSequentialGroup()
                .addGroup(pnl_bankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_bankTransferLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_bank_transfer, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(pnl_bankTransferLayout.createSequentialGroup()
                        .addGroup(pnl_bankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_bankTransferLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(pnl_bankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnl_bankTransferLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_bankTransferLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(pnl_bankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnl_bankTransferLayout.setVerticalGroup(
            pnl_bankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_bankTransferLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(pnl_bankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_bank_transfer, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnl_bankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField18, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnl_bankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(pnl_bankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 49, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_bankTransferLayout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jLabel40)
                .addGap(54, 54, 54))
        );

        pnl_Payment.add(pnl_bankTransfer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 1200, 340));

        pnl_FeesStructure.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel3.setText("University Fees Structure");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel4.setText("Tution Fees :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel5.setText("Development Fees :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel6.setText("Insurance Fees :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel7.setText("ICard :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel8.setText("Exam Fees :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel9.setText("Caution Money Deposit :");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel10.setText("Form and prospectus Fee :");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel11.setText("Total :");

        lbl_tution.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N

        lbl_development.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N

        lbl_insurance.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        lbl_insurance.setText(" ");

        lbl_exam.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        lbl_exam.setText(" ");

        lbl_id.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        lbl_id.setText(" ");

        lbl_cmd.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        lbl_cmd.setText(" ");

        lbl_formfee.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        lbl_formfee.setText(" ");

        lbl_total.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        lbl_total.setText(" ");

        lbl_photo.setText(" ");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel12.setText("Name :");

        lbl_name.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        lbl_name.setText(" ");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel14.setText("Department :");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel15.setText("Year :");

        lbl_dept.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lbl_dept.setText(" ");

        lbl_year.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        lbl_year.setText(" ");

        javax.swing.GroupLayout pnl_FeesStructureLayout = new javax.swing.GroupLayout(pnl_FeesStructure);
        pnl_FeesStructure.setLayout(pnl_FeesStructureLayout);
        pnl_FeesStructureLayout.setHorizontalGroup(
            pnl_FeesStructureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_FeesStructureLayout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addGroup(pnl_FeesStructureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel5))
                .addGroup(pnl_FeesStructureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_FeesStructureLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(pnl_FeesStructureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_tution, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_development, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_insurance, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addComponent(lbl_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_cmd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_formfee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnl_FeesStructureLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(lbl_exam, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(pnl_FeesStructureLayout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnl_FeesStructureLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnl_FeesStructureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_FeesStructureLayout.createSequentialGroup()
                        .addGroup(pnl_FeesStructureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_FeesStructureLayout.createSequentialGroup()
                                .addGap(213, 213, 213)
                                .addGroup(pnl_FeesStructureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnl_FeesStructureLayout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbl_name, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnl_FeesStructureLayout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                        .addComponent(lbl_dept, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbl_year, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_FeesStructureLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(169, 169, 169)))
                        .addComponent(lbl_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        pnl_FeesStructureLayout.setVerticalGroup(
            pnl_FeesStructureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_FeesStructureLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_FeesStructureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_photo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnl_FeesStructureLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(pnl_FeesStructureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_name)
                            .addComponent(jLabel12))
                        .addGap(29, 29, 29)
                        .addGroup(pnl_FeesStructureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(lbl_dept, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_year, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnl_FeesStructureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbl_tution, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_FeesStructureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(lbl_development, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_FeesStructureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbl_insurance))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_FeesStructureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(lbl_exam))
                .addGap(18, 18, 18)
                .addGroup(pnl_FeesStructureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbl_id))
                .addGap(18, 18, 18)
                .addGroup(pnl_FeesStructureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lbl_cmd))
                .addGap(18, 18, 18)
                .addGroup(pnl_FeesStructureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lbl_formfee))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(pnl_FeesStructureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lbl_total))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pnl_FeesNotPaid.setBackground(new java.awt.Color(255, 255, 255));

        jLabel70.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("To view Your Fees Receipt ");

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setText("Please pay your fees.");

        jButton1.setText("Pay Fees");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_FeesNotPaidLayout = new javax.swing.GroupLayout(pnl_FeesNotPaid);
        pnl_FeesNotPaid.setLayout(pnl_FeesNotPaidLayout);
        pnl_FeesNotPaidLayout.setHorizontalGroup(
            pnl_FeesNotPaidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_FeesNotPaidLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_FeesNotPaidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_FeesNotPaidLayout.createSequentialGroup()
                .addContainerGap(468, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(448, 448, 448))
        );
        pnl_FeesNotPaidLayout.setVerticalGroup(
            pnl_FeesNotPaidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_FeesNotPaidLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_receipt.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 41)); // NOI18N
        jLabel46.setText("University");

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel47.setText("(An Autonomous Institute of Govt.of Maharashta-Accredited by NBA-AICTE)");

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel48.setText("RECEIPT OF PAYMENT");

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel49.setText("Date :");

        rec_date.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel51.setText("Name :");

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel52.setText("Enrollment No. :");

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel53.setText("Voucher Id :");

        jLabel55.setBackground(new java.awt.Color(255, 102, 102));
        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel55.setText("Transaction Id :");

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel56.setText("Course :");

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel57.setText("Class :");

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel45.setText("AC GI NAME");
        jPanel4.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel58.setText("Recieved Amount");
        jPanel4.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, -1, -1));

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel59.setText("Paid Amount");
        jPanel4.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, -1, -1));

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel60.setText("Tution Fee");

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel61.setText("Development Fee");

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel62.setText("Insurance Fee");

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel63.setText("ICard");

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel64.setText("Exam Fee");

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel65.setText("Form and Prospectus Fee");

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel66.setText("Caution Money Deposit");

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 23)); // NOI18N
        jLabel67.setText("Voucher Total");

        lbl_r_development.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lbl_r_development.setText("jLabel69");

        lbl_r_insurance.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lbl_r_insurance.setText("jLabel70");

        lbl_r_id.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lbl_r_id.setText("jLabel71");

        lbl_r_exam.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lbl_r_exam.setText("jLabel72");

        lbl_r_formFee.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lbl_r_formFee.setText("jLabel73");

        lbl_r_moneyDeposit.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lbl_r_moneyDeposit.setText("jLabel74");

        lbl_r_total.setFont(new java.awt.Font("Tahoma", 1, 23)); // NOI18N
        lbl_r_total.setText("jLabel75");

        jLabel76.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel76.setText("0.00");

        jLabel77.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel77.setText("0.00");

        jLabel78.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel78.setText("0.00");

        jLabel79.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel79.setText("0.00");

        jLabel80.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel80.setText("0.00");

        jLabel81.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel81.setText("0.00");

        jLabel82.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel82.setText("0.00");

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 23)); // NOI18N
        jLabel83.setText("0.00");

        lbl_r_name.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lbl_r_name.setText("jLabel68");

        lbl_r_enroll.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lbl_r_enroll.setText("jLabel69");

        lbl_r_course.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lbl_r_course.setText("jLabel70");

        lbl_r_class.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lbl_r_class.setText("jLabel71");

        lbl_r_voucher.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lbl_r_voucher.setText(" ");

        lbl_r_trans.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N

        lbl_r_tution.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lbl_r_tution.setText("jLabel54");

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel54.setText("Payment Mode :");

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel68.setText("Bank Name :");

        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel69.setText("Amount Paid :");

        rec_paymentMode.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        rec_paymentMode.setText("jLabel70");

        rec_bankName.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        rec_bankName.setText("jLabel71");

        rec_amount.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        rec_amount.setText("jLabel72");

        jLabel73.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\College Project\\version 2.1\\Paid Final.png")); // NOI18N
        jLabel73.setText("Error 404 Image not found");

        jLabel74.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel74.setText("Cashier");

        jLabel75.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel75.setText("Anil Shamrao Deshmukh");

        jPanel5.setBackground(new java.awt.Color(254, 200, 218));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 84, 138)));

        jLabel84.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(204, 0, 51));
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel84.setText("N.B : 1) This receipt should be preserved . 2) This receipt must be produced at the time of refund");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel84, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                            .addComponent(jLabel66)
                                            .addGap(23, 23, 23))
                                        .addComponent(jLabel65)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                            .addComponent(jLabel64)
                                            .addGap(158, 158, 158))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                            .addComponent(jLabel63)
                                            .addGap(200, 200, 200))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                            .addComponent(jLabel62)
                                            .addGap(112, 112, 112))
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                                .addComponent(jLabel61)
                                                .addGap(80, 80, 80))
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(jLabel60)
                                                .addGap(149, 149, 149))))
                                    .addGap(324, 324, 324)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_r_moneyDeposit, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbl_r_formFee, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbl_r_exam, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbl_r_id, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbl_r_insurance, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_r_development)
                                            .addComponent(lbl_r_tution)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 269, Short.MAX_VALUE)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel82)
                                        .addComponent(jLabel81)
                                        .addComponent(jLabel80)
                                        .addComponent(jLabel79)
                                        .addComponent(jLabel78)
                                        .addComponent(jLabel76)
                                        .addComponent(jLabel77)))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel67)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 818, Short.MAX_VALUE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel54)
                                        .addGap(18, 18, 18)
                                        .addComponent(rec_paymentMode, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel68)
                                            .addComponent(jLabel69))
                                        .addGap(35, 35, 35)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rec_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rec_bankName, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 64, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 756, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel74)
                        .addGap(234, 234, 234))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(lbl_r_total)
                                .addGap(254, 254, 254)
                                .addComponent(jLabel83))
                            .addComponent(jLabel75))
                        .addGap(137, 137, 137))))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(jLabel47))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rec_date, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142)
                        .addComponent(jLabel48))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel51)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_r_name, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)
                        .addComponent(jLabel53)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_r_voucher, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel52)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_r_enroll, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(231, 231, 231)
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_r_trans, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_r_course, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(513, 513, 513)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1101, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel57)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_r_class, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator3)
                            .addComponent(jSeparator4))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel46)
                .addGap(18, 18, 18)
                .addComponent(jLabel47)
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49)
                            .addComponent(rec_date, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel53)
                        .addComponent(lbl_r_voucher))
                    .addComponent(lbl_r_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel52)
                        .addComponent(lbl_r_enroll))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel55)
                            .addComponent(lbl_r_trans, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(2, 2, 2)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(lbl_r_course))
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(lbl_r_class))
                .addGap(54, 54, 54)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel60)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel61)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel62)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel63)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel64)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel65)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(lbl_r_development)
                            .addGap(22, 22, 22)
                            .addComponent(lbl_r_insurance)
                            .addGap(22, 22, 22)
                            .addComponent(lbl_r_id)
                            .addGap(22, 22, 22)
                            .addComponent(lbl_r_exam)
                            .addGap(22, 22, 22)
                            .addComponent(lbl_r_formFee)
                            .addGap(22, 22, 22)
                            .addComponent(lbl_r_moneyDeposit))
                        .addComponent(lbl_r_tution))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel76)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel77)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel78)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel79)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel80)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel81)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel82)))
                .addGap(26, 26, 26)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel83)
                    .addComponent(lbl_r_total)
                    .addComponent(jLabel67))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54)
                            .addComponent(rec_paymentMode))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rec_bankName)
                            .addComponent(jLabel68))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel69)
                            .addComponent(rec_amount))
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel74)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel75)
                .addGap(79, 79, 79)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel6);

        javax.swing.GroupLayout pnl_receiptLayout = new javax.swing.GroupLayout(pnl_receipt);
        pnl_receipt.setLayout(pnl_receiptLayout);
        pnl_receiptLayout.setHorizontalGroup(
            pnl_receiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1224, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnl_receiptLayout.setVerticalGroup(
            pnl_receiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1414, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(pnl_FeesStructure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(pnl_Payment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_receipt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_FeesNotPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_Payment, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .addComponent(pnl_FeesStructure, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_receipt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_FeesNotPaid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 1200, 700));

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

        jLabel50.setBackground(new java.awt.Color(255, 255, 255));
        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("—");
        jLabel50.setOpaque(true);
        jLabel50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel50MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel50MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel50MouseExited(evt);
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

        jLabel72.setBackground(new java.awt.Color(51, 51, 51));
        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(51, 51, 51));
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setText("University Portal");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 507, Short.MAX_VALUE)
                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 936, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addGap(0, 23, Short.MAX_VALUE))
            .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1590, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_creditCvvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_creditCvvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_creditCvvActionPerformed

    private void tf_debitCvvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_debitCvvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_debitCvvActionPerformed

    private void cmb_paymentModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_paymentModeActionPerformed
        // TODO add your handling code here:
        
        paymentMode=(String)cmb_paymentMode.getSelectedItem();
//        System.out.println(paymentMode);


        if(paymentMode.equals("Debit Card")){
            pnl_cheaque.show(false);
            pnl_demandDraft.show(false);
            pnl_creditCard.show(false);
            pnl_bankTransfer.show(false);
            pnl_debitCard.show(true);
            
           
           
            
            
        }
        else if(paymentMode.equals("Credit Card")){
            pnl_cheaque.show(false);
            pnl_demandDraft.show(false);         
            pnl_bankTransfer.show(false);
            pnl_debitCard.show(false);
            pnl_creditCard.show(true);
            
            
            
        }
       else if(paymentMode.equals("Cheaque")){
           
            pnl_demandDraft.show(false);       
            pnl_bankTransfer.show(false);
            pnl_debitCard.show(false);
            pnl_creditCard.show(false);
            pnl_cheaque.show(true);
       }
       else if(paymentMode.equals("Demand Draft")){
           
            pnl_cheaque.show(false);           
            pnl_bankTransfer.show(false);
            pnl_debitCard.show(false);
            pnl_creditCard.show(false);
            pnl_demandDraft.show(true);
       } 
//        else if(paymentMode.equals("Bank Transfer")){
//           
//            pnl_cheaque.show(false);                    
//            pnl_debitCard.show(false);
//            pnl_creditCard.show(false);
//            pnl_demandDraft.show(false);
//            pnl_bankTransfer.show(true);
//       } 
        else{
               System.out.println("Sorry error 404");
         }
        
    }//GEN-LAST:event_cmb_paymentModeActionPerformed

    private void btn_feeStructureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_feeStructureActionPerformed
        // TODO add your handling code here:
       
        pnl_receipt.show(false);
          pnl_FeesNotPaid.setVisible(false);
        pnl_Payment.show(false);
        pnl_FeesStructure.show(true);
        
//        System.out.println("Fees Structure : "+lbl_tution.getText());
//        System.out.println("Fees Structure : "+lbl_development.getText());
//        
//        lbl_r_tution.setText(lbl_tution.getText());
//        lbl_r_development.setText(lbl_development.getText());
//        lbl_r_insurance.setText(lbl_insurance.getText());
//        lbl_r_exam.setText(lbl_exam.getText());
//        lbl_r_id.setText(lbl_id.getText());
//        lbl_r_moneyDeposit.setText(lbl_cmd.getText());
//        lbl_r_formFee.setText(lbl_formfee.getText());
//        lbl_r_total.setText(lbl_total.getText());
//        
//        System.out.println("Fees receipt : " +lbl_r_tution.getText());
//        System.out.println("Fees receipt : " +lbl_r_development.getText());
         
         
          
        
  
    }//GEN-LAST:event_btn_feeStructureActionPerformed

    private void btn_paymentDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_paymentDetailsActionPerformed
        // TODO add your handling code here:
            pnl_FeesStructure.setVisible(false); 
               pnl_FeesNotPaid.setVisible(false);
            pnl_receipt.setVisible(false);
             pnl_Payment.setVisible(true);  

        
    }//GEN-LAST:event_btn_paymentDetailsActionPerformed

    private void btn_feesReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_feesReceiptActionPerformed
        // TODO add your handling code here:
        
        
        
        pnl_FeesStructure.setVisible(false);    
        pnl_Payment.setVisible(false);
        pnl_receipt.setVisible(false); 
        pnl_FeesNotPaid.setVisible(true);
//        pnl_FeesNotPaid.setBounds(401,173,1200,680);
        
       
        
        
        System.out.println("Fees Structure : "+lbl_tution.getText());
        System.out.println("Fees Structure : "+lbl_development.getText());
        
        lbl_r_tution.setText(lbl_tution.getText());
        lbl_r_development.setText(lbl_development.getText());
        lbl_r_insurance.setText(lbl_insurance.getText());
        lbl_r_exam.setText(lbl_exam.getText());
        lbl_r_id.setText(lbl_id.getText());
        lbl_r_moneyDeposit.setText(lbl_cmd.getText());
        lbl_r_formFee.setText(lbl_formfee.getText());
        lbl_r_total.setText(lbl_total.getText());
        
        System.out.println("Fees receipt : " +lbl_r_tution.getText());
        System.out.println("Fees receipt : " +lbl_r_development.getText());
        
        lbl_r_name.setText(lbl_name.getText());
        lbl_r_enroll.setText(ret_enroll);
        lbl_r_class.setText(ret_year+" "+ret_dept);
        lbl_r_course.setText("Diploma in "+lbl_dept.getText()+" [Full Time]");
        System.out.println(lbl_r_name.getText());
        System.out.println(lbl_r_enroll.getText());
        System.out.println(lbl_r_class.getText());
        System.out.println(lbl_r_course.getText());
                
          
        

    }//GEN-LAST:event_btn_feesReceiptActionPerformed

    private void tf_creditCardNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_creditCardNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_creditCardNameActionPerformed

    private void btn_makePaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_makePaymentActionPerformed
        // TODO add your handling code here:
        
//        btn_feesReceipt.setEnabled(true);
        
         
        pnl_FeesStructure.setVisible(false);    
        pnl_Payment.setVisible(false);
       
        pnl_FeesNotPaid.setVisible(false);
        pnl_receipt.setVisible(true);
        
        btn_print.setVisible(true);
        
        Date selectedDate = jDateChooser1.getDate();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        bdate = dateformat.format(selectedDate);
        
        rec_date.setText(bdate);
        lbl_r_trans.setText(trc_id);
        
        lbl_r_voucher.setText("AJH"+trc_id); 
      
        
        try{
            if(paymentMode.equals("Debit Card"))
            { 
            debitNo=tf_debitCardNo.getText();
            debitName=tf__debit_nameOnCard.getText();
            debitCvv=tf_debitCvv.getText();
            debitBank=(String)cmb_debitBank.getSelectedItem();
            
             System.out.println("Debit crd no  " +debitNo);
            System.out.println("Debit crd name " +debitName);
            System.out.println("Debit crd cvv " +debitCvv);
            System.out.println("Debit crd bank " +debitBank);
            }
            else if(paymentMode.equals("Credit Card"))
            {
            creditNo=tf_creditCardNo.getText();
            creditName=tf_creditCardName.getText();
            creditCvv=tf_creditCvv.getText();
            creditBank=(String)cmb_creditBank.getSelectedItem();
            
            System.out.println(creditNo);
            System.out.println(creditName);
            System.out.println(creditCvv);
            System.out.println(creditBank);
            }
            
            
            
            else if(paymentMode.equals("Demand Draft"))
            {
            dd=tf_dd_draft.getText();
            ddAccNo=tf_dd_AccNo.getText();
            ddIFSC=tf_dd_IFSC.getText();
            ddBank=(String)cmb_dd_bank.getSelectedItem();
            }
            
            else if(paymentMode.equals("Cheaque"))
            {
            cheaqueNo=tf_cheaqueNo.getText();
            cheaqueAccNo=tf_cheaque_AccNo.getText();
            cheaqueIFSC=tf_cheaque_IFSC.getText();
            cheaqueBank=(String)cmb_cheaque_bank.getSelectedItem();
            }
            else
            {
                System.out.println("NOthing working");
            }

        }
        catch(Exception e)
        {
            e.getMessage();
        }
        //*****************************************************************************
        
        
        if(paymentMode.equals("Debit Card"))
         {
            rec_paymentMode.setText("Debit Card");
            rec_bankName.setText(debitBank);
            rec_amount.setText(lbl_total.getText());

            System.out.println(" working"+rec_paymentMode);
            System.out.println(" working"+rec_bankName);
            System.out.println(" working"+rec_amount);
     
         }
        
       else if(paymentMode.equals("Credit Card"))
         {
            rec_paymentMode.setText("Credit Card");
            rec_bankName.setText(creditBank);
            rec_amount.setText(lbl_total.getText());

            System.out.println(" working"+rec_paymentMode);
            System.out.println(" working"+rec_bankName);
            System.out.println(" working"+rec_amount);
     
         }
       
       else if(paymentMode.equals("Cheaque"))
         {
            rec_paymentMode.setText("Cheaque");
            rec_bankName.setText(cheaqueBank);
            rec_amount.setText(lbl_total.getText());

            System.out.println(" working"+rec_paymentMode);
            System.out.println(" working"+rec_bankName);
            System.out.println(" working"+rec_amount);
     
         }
       else if(paymentMode.equals("Demand Draft"))
         {
            rec_paymentMode.setText("Demand Draft");
            rec_bankName.setText(ddBank);
            rec_amount.setText(lbl_total.getText());

            System.out.println(" working"+rec_paymentMode);
            System.out.println(" working"+rec_bankName);
            System.out.println(" working"+rec_amount);
     
         }
        if(paymentMode.equals("Bank Transfer"))
         {
            rec_paymentMode.setText("Bank Transfer");
            rec_bankName.setText(debitBank);
            rec_amount.setText(lbl_total.getText());

            System.out.println(" working"+rec_paymentMode);
            System.out.println(" working"+rec_bankName);
            System.out.println(" working"+rec_amount);
     
         }
           
            
            
            
    }//GEN-LAST:event_btn_makePaymentActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
          
       
        pnl_FeesNotPaid.setVisible(false);
        pnl_receipt.setVisible(false);
        pnl_FeesStructure.setVisible(false); 
        pnl_Payment.setVisible(true); 
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        // TODO add your handling code here:   
        printRecord(jPanel6);
    }//GEN-LAST:event_btn_printActionPerformed

    private void tf_creditCardNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_creditCardNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_creditCardNoActionPerformed

    private void jLabel50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseClicked
        // TODO add your handling code here:

        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_jLabel50MouseClicked

    private void jLabel50MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseEntered
        // TODO add your handling code here:
        jLabel25.setBackground(new Color(229,229,229));
    }//GEN-LAST:event_jLabel50MouseEntered

    private void jLabel50MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseExited
        // TODO add your handling code here:

        jLabel25.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jLabel50MouseExited

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
            java.util.logging.Logger.getLogger(Fees_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fees_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fees_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fees_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fees_Management().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_feeStructure;
    private javax.swing.JButton btn_feesReceipt;
    private javax.swing.JButton btn_makePayment;
    private javax.swing.JButton btn_paymentDetails;
    private javax.swing.JButton btn_print;
    private javax.swing.JComboBox<String> cmb_cheaque_bank;
    private javax.swing.JComboBox<String> cmb_creditBank;
    private javax.swing.JComboBox<String> cmb_dd_bank;
    private javax.swing.JComboBox<String> cmb_debitBank;
    private javax.swing.JComboBox<String> cmb_paymentMode;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lbl_cmd;
    private javax.swing.JLabel lbl_dept;
    private javax.swing.JLabel lbl_development;
    private javax.swing.JLabel lbl_exam;
    private javax.swing.JLabel lbl_formfee;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_insurance;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_photo;
    private javax.swing.JLabel lbl_r_class;
    private javax.swing.JLabel lbl_r_course;
    private javax.swing.JLabel lbl_r_development;
    private javax.swing.JLabel lbl_r_enroll;
    private javax.swing.JLabel lbl_r_exam;
    private javax.swing.JLabel lbl_r_formFee;
    private javax.swing.JLabel lbl_r_id;
    private javax.swing.JLabel lbl_r_insurance;
    private javax.swing.JLabel lbl_r_moneyDeposit;
    private javax.swing.JLabel lbl_r_name;
    private javax.swing.JLabel lbl_r_total;
    private javax.swing.JLabel lbl_r_trans;
    private javax.swing.JLabel lbl_r_tution;
    private javax.swing.JLabel lbl_r_voucher;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JLabel lbl_tution;
    private javax.swing.JLabel lbl_year;
    private javax.swing.JPanel pnl_FeesNotPaid;
    private javax.swing.JPanel pnl_FeesStructure;
    private javax.swing.JPanel pnl_Payment;
    private javax.swing.JPanel pnl_bankTransfer;
    private javax.swing.JPanel pnl_cheaque;
    private javax.swing.JPanel pnl_creditCard;
    private javax.swing.JPanel pnl_debitCard;
    private javax.swing.JPanel pnl_demandDraft;
    private javax.swing.JPanel pnl_paymentInformation;
    private javax.swing.JPanel pnl_receipt;
    private javax.swing.JLabel rec_amount;
    private javax.swing.JLabel rec_bankName;
    private javax.swing.JLabel rec_date;
    private javax.swing.JLabel rec_paymentMode;
    private javax.swing.JTextField tf__debit_nameOnCard;
    private javax.swing.JTextField tf_bank_transfer;
    private javax.swing.JTextField tf_cheaqueNo;
    private javax.swing.JTextField tf_cheaque_AccNo;
    private javax.swing.JTextField tf_cheaque_IFSC;
    private javax.swing.JTextField tf_creditCardName;
    private javax.swing.JTextField tf_creditCardNo;
    private javax.swing.JPasswordField tf_creditCvv;
    private javax.swing.JTextField tf_dd_AccNo;
    private javax.swing.JTextField tf_dd_IFSC;
    private javax.swing.JTextField tf_dd_draft;
    private javax.swing.JTextField tf_debitCardNo;
    private javax.swing.JPasswordField tf_debitCvv;
    // End of variables declaration//GEN-END:variables

 private void printRecord(JPanel panel){
        // Create PrinterJob Here
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        // Set Printer Job Name
        printerJob.setJobName("Print Record");
        // Set Printable
        printerJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                // Check If No Printable Content
                if(pageIndex > 0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                // Make 2D Graphics to map content
                Graphics2D graphics2D = (Graphics2D)graphics;
                // Set Graphics Translations
                // A Little Correction here Multiplication was not working so I replaced with addition
                graphics2D.translate(pageFormat.getImageableX()+10, pageFormat.getImageableY()+10);
                // This is a page scale. Default should be 0.3 I am using 0.5
                graphics2D.scale(0.5, 0.5);
                
                // Now paint panel as graphics2D
                panel.paint(graphics2D);
                
                // return if page exists
                return Printable.PAGE_EXISTS;
            }
        });
        // Store printerDialog as boolean
        boolean returningResult = printerJob.printDialog();
        // check if dilog is showing
        if(returningResult){
            // Use try catch exeption for failure
            try{
                // Now call print method inside printerJob to print
                printerJob.print();
            }catch (PrinterException printerException){
                JOptionPane.showMessageDialog(this, "Print Error: " + printerException.getMessage());
            }
        }
    }

    
}
