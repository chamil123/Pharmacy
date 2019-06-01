/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy.view;

import de.javasoft.plaf.synthetica.SyntheticaBlueSteelLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import pharmacy.controller.BatchController;
import pharmacy.controller.CustomerController;
import pharmacy.controller.DrugController;
import pharmacy.controller.InvoiceController;
import pharmacy.controller.InvoiceLineController;
import pharmacy.controller.UserController;
import pharmacy.model.Batch;
import pharmacy.model.Customer;
import pharmacy.model.Drug;
import pharmacy.model.Invoice;
import pharmacy.model.InvoiceLine;
import pharmacy.model.User;

/**
 *
 * @author chami
 */
public class CreateInvoice extends javax.swing.JFrame {

    private boolean dot = false;
    String drug_id = "";
    String unitPrice = "";

    /**
     * Creates new form Invoice
     */
    public CreateInvoice() {
        try {
            initComponents();
            javax.swing.Timer t = new javax.swing.Timer(1000, new ClockListener());
            t.start();

            jPanel7.setVisible(false);
            jScrollPane6.setVisible(false);
            // jTable10.getTableHeader().setVisible(false); 
            jTable10.setVisible(false);
            Customer customer = CustomerController.searchCustomerByNameDefault("Default");
            jTextField4.setText(customer.getCus_firstName() + " " + customer.getCus_lastName());

            jTextField1.grabFocus();

            DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
            rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
            jTable3.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
            jTextField6.setText("0");

            int getMaxId = InvoiceController.getMaxId();
            String formatted = String.format("%06d", getMaxId);
            jLabel4.setText("" + formatted);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateInvoice.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CreateInvoice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void tablePaymentTotal() {
        DecimalFormat df = new DecimalFormat("##.00");
        DefaultTableModel tb1 = (DefaultTableModel) jTable3.getModel();
        int rowCount = tb1.getRowCount();
        double totalPayment = 0;
        double totalDiscount = 0;
        double disAmount = 0;
        for (int i = 0; i < rowCount; i++) {
            double quantity = Double.parseDouble(tb1.getValueAt(i, 2).toString());
            double price = Double.parseDouble(tb1.getValueAt(i, 3).toString());
            double discount = Double.parseDouble(tb1.getValueAt(i, 4).toString());

            double totAmount = quantity * price;
            disAmount += (totAmount * discount) / 100;

            totalPayment += Double.parseDouble(tb1.getValueAt(i, 5).toString());
            totalDiscount += Double.parseDouble(tb1.getValueAt(i, 4).toString());
        }
        double discount = 0;
        if (!jTextField11.getText().equals("")) {
            discount = Double.parseDouble(jTextField11.getText());
        } else {
            discount = 0;
        }
        double payAmount = 0;
        if (!jTextField11.getText().equals("")) {
            payAmount = Double.parseDouble(jTextField12.getText());
        } else {
            payAmount = 0;
        }

        jLabel77.setText("" + df.format(totalPayment).toString());
        jLabel75.setText("" + rowCount);
        jLabel79.setText("" + totalDiscount);
        jLabel81.setText("" + disAmount);

        double mainDiscount = (totalPayment * discount) / 100;
        jLabel7.setText("" + df.format(totalPayment - mainDiscount).toString());

        jLabel82.setText("" + df.format(payAmount - (totalPayment - mainDiscount)).toString());

    }

    public class ClockListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Date d;
            DateFormat dateFormat;
            SimpleDateFormat sdf;
            SimpleDateFormat sdf1;
            String date;
            d = new Date();
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            sdf = new SimpleDateFormat("hh:mm:ss");
            sdf1 = new SimpleDateFormat("a");
            jLabel24.setText(sdf.format(d));

            jLabel25.setText(dateFormat.format(d));

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jButton17 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        jTextField5 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel39 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jPanel52 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jPanel55 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jPanel56 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jPanel57 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jLabel63 = new javax.swing.JLabel();
        jPanel58 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        jPanel59 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jLabel65 = new javax.swing.JLabel();
        jPanel60 = new javax.swing.JPanel();
        jButton18 = new javax.swing.JButton();
        jLabel66 = new javax.swing.JLabel();
        jPanel64 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        jLabel70 = new javax.swing.JLabel();
        jPanel63 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jLabel69 = new javax.swing.JLabel();
        jPanel62 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jLabel68 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jPanel67 = new javax.swing.JPanel();
        jButton19 = new javax.swing.JButton();
        jLabel73 = new javax.swing.JLabel();
        jPanel66 = new javax.swing.JPanel();
        jButton16 = new javax.swing.JButton();
        jLabel72 = new javax.swing.JLabel();
        jPanel65 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        jPanel61 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jLabel67 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(1367, 729));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(62, 69, 76));

        jPanel9.setBackground(new java.awt.Color(62, 69, 76));
        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel9.setForeground(new java.awt.Color(51, 51, 51));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(204, 204, 204));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(62, 69, 76));
        jPanel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 204, 204));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel11.setBackground(new java.awt.Color(62, 69, 76));
        jPanel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(204, 204, 204));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Administrator");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(555, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1367, 60));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Drug name", "Drug ID", "Generic Name", "Brand", "Unit Cost", "Unit Price", "Available Stock", "Expire Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable10.setRowHeight(20);
        jTable10.getTableHeader().setReorderingAllowed(false);
        jTable10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable10MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable10MousePressed(evt);
            }
        });
        jTable10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable10KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable10KeyReleased(evt);
            }
        });
        jScrollPane6.setViewportView(jTable10);
        if (jTable10.getColumnModel().getColumnCount() > 0) {
            jTable10.getColumnModel().getColumn(0).setMinWidth(250);
            jTable10.getColumnModel().getColumn(0).setMaxWidth(200);
            jTable10.getColumnModel().getColumn(1).setMinWidth(60);
            jTable10.getColumnModel().getColumn(1).setMaxWidth(60);
            jTable10.getColumnModel().getColumn(4).setMinWidth(90);
            jTable10.getColumnModel().getColumn(4).setMaxWidth(50);
            jTable10.getColumnModel().getColumn(5).setMinWidth(90);
            jTable10.getColumnModel().getColumn(5).setMaxWidth(60);
            jTable10.getColumnModel().getColumn(6).setMinWidth(90);
            jTable10.getColumnModel().getColumn(6).setMaxWidth(90);
            jTable10.getColumnModel().getColumn(7).setMinWidth(90);
            jTable10.getColumnModel().getColumn(7).setMaxWidth(90);
        }

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 152, 960, 240));

        jTextField1.setBackground(new java.awt.Color(255, 204, 51));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTextField1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel5.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 162, 34));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 118, 350, 34));

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTextField2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField2FocusGained(evt);
            }
        });
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        jPanel5.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 120, 32));

        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextField3.setEnabled(false);
        jPanel5.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 120, 128, 32));

        jButton1.setText("Add");
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 120, 70, 32));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 163, 0, 10));

        jTable3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#Item Code", "Item", "Quantity", "Price", "Discount", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setRowHeight(20);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setHeaderValue("#Item Code");
            jTable3.getColumnModel().getColumn(1).setHeaderValue("Item");
            jTable3.getColumnModel().getColumn(2).setHeaderValue("Quantity");
            jTable3.getColumnModel().getColumn(3).setHeaderValue("Price");
            jTable3.getColumnModel().getColumn(4).setHeaderValue("Discount");
            jTable3.getColumnModel().getColumn(5).setHeaderValue("Amount");
        }

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 163, 970, 240));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Bill number  :");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 140, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Patient Name  :");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 140, 30));

        jTextField4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });
        jPanel5.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 250, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 250, 30));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Sales By  :");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 140, -1));

        jLabel6.setText("jLabel6");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 190, -1));

        jTextField6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextField6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField6FocusGained(evt);
            }
        });
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField6KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });
        jPanel5.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, 90, 30));

        jLabel27.setText("Amount");
        jPanel5.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 90, -1));

        jLabel28.setText("Item discount");
        jPanel5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 100, -1, -1));

        jLabel29.setText("Unit Price");
        jPanel5.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 100, -1, -1));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 990, 420));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 38)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("0.00");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel8.setText("Total : ");

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(0, 0, 153));
        jLabel74.setText("Tootal Items :");

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(0, 0, 153));
        jLabel76.setText("Sub Total :");

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(0, 0, 204));
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel77.setText("0.00");

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(51, 51, 51));
        jLabel78.setText("Total Line Dis %");

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel79.setText("0.00");

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(0, 0, 153));
        jLabel80.setText("Total Line Dis Amount");

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel81.setText("0.00");

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 0, 0));
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel82.setText("0.00");

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(0, 0, 153));
        jLabel83.setText("Change");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("  [Esc]  Cash");
        jRadioButton1.setFocusPainted(false);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("  [F6] Cheque");
        jRadioButton2.setFocusPainted(false);

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("  [F7] Credit");
        jRadioButton3.setFocusPainted(false);
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(0, 0, 255));
        jLabel84.setText("Discount rate  %        :");

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(0, 0, 255));
        jLabel85.setText("Amount                       :");

        jTextField11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextField11.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField11FocusGained(evt);
            }
        });
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField11KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField11KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField11KeyTyped(evt);
            }
        });

        jTextField12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField12.setForeground(new java.awt.Color(0, 0, 153));
        jTextField12.setText("0");
        jTextField12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextField12.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField12FocusGained(evt);
            }
        });
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField12KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField12KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField12KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 413, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField11))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel76)
                            .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel78)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField11)
                                    .addComponent(jLabel84, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addGap(9, 9, 9)
                                .addComponent(jRadioButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton3)))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel79))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel81))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 990, 190));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1010, 670));

        jPanel8.setBackground(new java.awt.Color(102, 204, 255));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("0");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 620, 75, 70));

        jPanel12.setBackground(new java.awt.Color(102, 204, 255));
        jPanel12.setMaximumSize(new java.awt.Dimension(78, 70));
        jPanel12.setMinimumSize(new java.awt.Dimension(78, 70));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("00");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1105, 620, -1, 70));

        jPanel13.setBackground(new java.awt.Color(102, 204, 255));
        jPanel13.setMaximumSize(new java.awt.Dimension(78, 70));
        jPanel13.setMinimumSize(new java.awt.Dimension(78, 70));

        jLabel11.setBackground(new java.awt.Color(0, 204, 153));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText(".");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 620, -1, 70));

        jPanel14.setBackground(new java.awt.Color(255, 102, 102));
        jPanel14.setMinimumSize(new java.awt.Dimension(75, 70));

        jLabel10.setBackground(new java.awt.Color(255, 102, 102));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1275, 620, 75, 70));

        jPanel15.setBackground(new java.awt.Color(102, 204, 255));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("*");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 540, -1, -1));

        jPanel16.setBackground(new java.awt.Color(102, 204, 255));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("-");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 460, -1, -1));

        jPanel17.setBackground(new java.awt.Color(102, 204, 255));
        jPanel17.setMaximumSize(new java.awt.Dimension(75, 70));
        jPanel17.setMinimumSize(new java.awt.Dimension(75, 70));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 380, 75, 70));

        jPanel18.setBackground(new java.awt.Color(102, 204, 255));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("1");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1105, 540, -1, -1));

        jPanel19.setBackground(new java.awt.Color(102, 204, 255));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("2");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 540, -1, -1));

        jPanel20.setBackground(new java.awt.Color(102, 204, 255));
        jPanel20.setMaximumSize(new java.awt.Dimension(75, 70));
        jPanel20.setMinimumSize(new java.awt.Dimension(75, 70));
        jPanel20.setPreferredSize(new java.awt.Dimension(75, 70));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("3");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1275, 540, -1, -1));

        jPanel21.setBackground(new java.awt.Color(102, 204, 255));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("4");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1105, 460, -1, -1));

        jPanel22.setBackground(new java.awt.Color(102, 204, 255));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("5");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 460, -1, -1));

        jPanel23.setBackground(new java.awt.Color(102, 204, 255));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("6");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(1275, 460, -1, -1));

        jPanel24.setBackground(new java.awt.Color(102, 204, 255));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("7");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(1105, 380, -1, -1));

        jPanel25.setBackground(new java.awt.Color(102, 204, 255));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("8");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 380, -1, -1));

        jPanel26.setBackground(new java.awt.Color(102, 204, 255));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("9");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1275, 380, -1, -1));

        jPanel28.setBackground(new java.awt.Color(214, 214, 214));
        jPanel28.setMaximumSize(new java.awt.Dimension(80, 80));
        jPanel28.setMinimumSize(new java.awt.Dimension(80, 80));
        jPanel28.setLayout(null);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Print-icon2.png"))); // NOI18N
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Print-icon3.png"))); // NOI18N
        jPanel28.add(jButton7);
        jButton7.setBounds(0, 0, 80, 70);

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Print");
        jPanel28.add(jLabel31);
        jLabel31.setBounds(10, 61, 60, 30);

        jPanel1.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(1103, 280, 80, 90));

        jPanel29.setBackground(new java.awt.Color(214, 214, 214));
        jPanel29.setMaximumSize(new java.awt.Dimension(80, 80));
        jPanel29.setMinimumSize(new java.awt.Dimension(80, 80));
        jPanel29.setLayout(null);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Print-icon2.png"))); // NOI18N
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Print-icon3.png"))); // NOI18N
        jPanel29.add(jButton9);
        jButton9.setBounds(0, 0, 80, 70);

        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Print");
        jPanel29.add(jLabel32);
        jLabel32.setBounds(10, 61, 60, 30);

        jPanel1.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(1187, 280, 80, 90));

        jPanel30.setBackground(new java.awt.Color(214, 214, 214));
        jPanel30.setMaximumSize(new java.awt.Dimension(80, 80));
        jPanel30.setMinimumSize(new java.awt.Dimension(80, 80));
        jPanel30.setLayout(null);

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Print-icon2.png"))); // NOI18N
        jButton17.setBorderPainted(false);
        jButton17.setContentAreaFilled(false);
        jButton17.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Print-icon3.png"))); // NOI18N
        jPanel30.add(jButton17);
        jButton17.setBounds(0, 0, 80, 70);

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Print");
        jPanel30.add(jLabel33);
        jLabel33.setBounds(10, 61, 60, 30);

        jPanel1.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 280, 80, 90));

        jPanel31.setPreferredSize(new java.awt.Dimension(1367, 729));
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel32.setBackground(new java.awt.Color(62, 69, 76));

        jPanel33.setBackground(new java.awt.Color(62, 69, 76));
        jPanel33.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel33.setForeground(new java.awt.Color(51, 51, 51));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(204, 204, 204));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel34.setBackground(new java.awt.Color(62, 69, 76));
        jPanel34.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(204, 204, 204));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel35.setBackground(new java.awt.Color(62, 69, 76));
        jPanel35.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(204, 204, 204));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Administrator");

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(555, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel31.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1367, 60));

        jPanel36.setBackground(new java.awt.Color(51, 51, 51));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Drug name", "Drug ID", "Generic Name", "Brand", "Unit Cost", "Unit Price", "Available Stock", "Expire Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable11.setRowHeight(20);
        jTable11.getTableHeader().setReorderingAllowed(false);
        jTable11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable11MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable11MousePressed(evt);
            }
        });
        jTable11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable11KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable11KeyReleased(evt);
            }
        });
        jScrollPane7.setViewportView(jTable11);

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );

        jPanel37.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 960, 260));

        jTextField5.setBackground(new java.awt.Color(255, 204, 51));
        jTextField5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });
        jPanel37.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 162, 32));

        jLabel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel37.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 350, 32));

        jTextField7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jPanel37.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 120, 32));

        jTextField8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextField8.setEnabled(false);
        jPanel37.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 120, 128, 32));

        jButton2.setText("Add");
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });
        jPanel37.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 120, 70, 32));

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel37.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 163, 0, 10));

        jTable4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Item", "Quantity", "Price", "", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setRowHeight(20);
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jPanel37.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 168, 970, 300));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel38.setText("Bill number  :");
        jPanel37.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 140, 20));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel39.setText("Customer  :");
        jPanel37.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 140, 30));

        jTextField9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel37.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 250, 30));

        jLabel40.setText("jLabel4");
        jLabel40.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel37.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 250, 30));

        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel41.setText("Sales By  :");
        jPanel37.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 140, -1));

        jLabel42.setText("jLabel6");
        jPanel37.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 190, -1));

        jTextField10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jPanel37.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, 90, 30));

        jLabel43.setText("Amount");
        jPanel37.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 90, -1));

        jLabel44.setText("Item discount");
        jPanel37.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 100, -1, -1));

        jLabel45.setText("Unit Price");
        jPanel37.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 100, -1, -1));

        jPanel36.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 990, 480));

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel46.setText("54,895.00");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel47.setText("Total : ");

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addContainerGap(558, Short.MAX_VALUE)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jPanel36.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 990, 130));

        jPanel31.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1010, 670));

        jPanel41.setBackground(new java.awt.Color(102, 204, 255));

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("0");

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel31.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 620, 75, 70));

        jPanel42.setBackground(new java.awt.Color(102, 204, 255));
        jPanel42.setMaximumSize(new java.awt.Dimension(78, 70));
        jPanel42.setMinimumSize(new java.awt.Dimension(78, 70));

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("00");

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel31.add(jPanel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(1105, 620, -1, 70));

        jPanel43.setBackground(new java.awt.Color(102, 204, 255));
        jPanel43.setMaximumSize(new java.awt.Dimension(78, 70));
        jPanel43.setMinimumSize(new java.awt.Dimension(78, 70));

        jLabel50.setBackground(new java.awt.Color(0, 204, 153));
        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText(".");

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel31.add(jPanel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 620, -1, 70));

        jPanel44.setBackground(new java.awt.Color(255, 102, 102));
        jPanel44.setMinimumSize(new java.awt.Dimension(75, 70));

        jLabel51.setBackground(new java.awt.Color(255, 102, 102));
        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel31.add(jPanel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(1275, 620, 75, 70));

        jPanel45.setBackground(new java.awt.Color(102, 204, 255));

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("*");

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel31.add(jPanel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 540, -1, -1));

        jPanel46.setBackground(new java.awt.Color(102, 204, 255));

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("-");

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel31.add(jPanel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 460, -1, -1));

        jPanel47.setBackground(new java.awt.Color(102, 204, 255));
        jPanel47.setMaximumSize(new java.awt.Dimension(75, 70));
        jPanel47.setMinimumSize(new java.awt.Dimension(75, 70));

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel31.add(jPanel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 380, 75, 70));

        jPanel48.setBackground(new java.awt.Color(102, 204, 255));

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("1");

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel31.add(jPanel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(1105, 540, -1, -1));

        jPanel49.setBackground(new java.awt.Color(102, 204, 255));

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("2");

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel31.add(jPanel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 540, -1, -1));

        jPanel50.setBackground(new java.awt.Color(102, 204, 255));
        jPanel50.setMaximumSize(new java.awt.Dimension(75, 70));
        jPanel50.setMinimumSize(new java.awt.Dimension(75, 70));

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("3");

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel31.add(jPanel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(1275, 540, -1, -1));

        jPanel51.setBackground(new java.awt.Color(102, 204, 255));

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("4");

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel31.add(jPanel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(1105, 460, -1, -1));

        jPanel52.setBackground(new java.awt.Color(102, 204, 255));

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("5");

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel31.add(jPanel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 460, -1, -1));

        jPanel53.setBackground(new java.awt.Color(102, 204, 255));

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("6");

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel31.add(jPanel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(1275, 460, -1, -1));

        jPanel54.setBackground(new java.awt.Color(102, 204, 255));

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("7");

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel31.add(jPanel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(1105, 380, -1, -1));

        jPanel55.setBackground(new java.awt.Color(102, 204, 255));

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("8");

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel31.add(jPanel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 380, -1, -1));

        jPanel56.setBackground(new java.awt.Color(102, 204, 255));

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("9");

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel31.add(jPanel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(1275, 380, -1, -1));

        jPanel57.setBackground(new java.awt.Color(214, 214, 214));
        jPanel57.setMaximumSize(new java.awt.Dimension(80, 80));
        jPanel57.setMinimumSize(new java.awt.Dimension(80, 80));
        jPanel57.setLayout(null);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Print-icon2.png"))); // NOI18N
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Print-icon3.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel57.add(jButton6);
        jButton6.setBounds(0, 0, 80, 70);

        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setText("Print");
        jPanel57.add(jLabel63);
        jLabel63.setBounds(10, 61, 60, 30);

        jPanel31.add(jPanel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 280, 80, 90));

        jPanel58.setBackground(new java.awt.Color(214, 214, 214));
        jPanel58.setMaximumSize(new java.awt.Dimension(80, 80));
        jPanel58.setMinimumSize(new java.awt.Dimension(80, 80));
        jPanel58.setLayout(null);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Print-icon2.png"))); // NOI18N
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Print-icon3.png"))); // NOI18N
        jPanel58.add(jButton8);
        jButton8.setBounds(0, 0, 80, 70);

        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("Print");
        jPanel58.add(jLabel64);
        jLabel64.setBounds(10, 61, 60, 30);

        jPanel31.add(jPanel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(1103, 280, 80, 90));

        jPanel59.setBackground(new java.awt.Color(214, 214, 214));
        jPanel59.setMaximumSize(new java.awt.Dimension(80, 80));
        jPanel59.setMinimumSize(new java.awt.Dimension(80, 80));
        jPanel59.setLayout(null);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Print-icon2.png"))); // NOI18N
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Print-icon3.png"))); // NOI18N
        jPanel59.add(jButton10);
        jButton10.setBounds(0, 0, 80, 70);

        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setText("Print");
        jPanel59.add(jLabel65);
        jLabel65.setBounds(10, 61, 60, 30);

        jPanel31.add(jPanel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(1187, 280, 80, 90));

        jPanel60.setBackground(new java.awt.Color(214, 214, 214));
        jPanel60.setMaximumSize(new java.awt.Dimension(80, 80));
        jPanel60.setMinimumSize(new java.awt.Dimension(80, 80));
        jPanel60.setLayout(null);

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Print-icon2.png"))); // NOI18N
        jButton18.setBorderPainted(false);
        jButton18.setContentAreaFilled(false);
        jButton18.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Print-icon3.png"))); // NOI18N
        jPanel60.add(jButton18);
        jButton18.setBounds(0, 0, 80, 70);

        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setText("Print");
        jPanel60.add(jLabel66);
        jLabel66.setBounds(10, 61, 60, 30);

        jPanel31.add(jPanel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 280, 80, 90));

        jPanel64.setBackground(new java.awt.Color(214, 214, 214));
        jPanel64.setMaximumSize(new java.awt.Dimension(80, 80));
        jPanel64.setMinimumSize(new java.awt.Dimension(80, 80));
        jPanel64.setLayout(null);

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Print-icon2.png"))); // NOI18N
        jButton14.setBorderPainted(false);
        jButton14.setContentAreaFilled(false);
        jButton14.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Print-icon3.png"))); // NOI18N
        jPanel64.add(jButton14);
        jButton14.setBounds(0, 0, 80, 70);

        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("Print");
        jPanel64.add(jLabel70);
        jLabel70.setBounds(10, 61, 60, 30);

        jPanel31.add(jPanel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 180, 80, 90));

        jPanel63.setBackground(new java.awt.Color(214, 214, 214));
        jPanel63.setMaximumSize(new java.awt.Dimension(80, 80));
        jPanel63.setMinimumSize(new java.awt.Dimension(80, 80));
        jPanel63.setLayout(null);

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Print-icon2.png"))); // NOI18N
        jButton13.setBorderPainted(false);
        jButton13.setContentAreaFilled(false);
        jButton13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Print-icon3.png"))); // NOI18N
        jPanel63.add(jButton13);
        jButton13.setBounds(0, 0, 80, 70);

        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel69.setText("Print");
        jPanel63.add(jLabel69);
        jLabel69.setBounds(10, 61, 60, 30);

        jPanel31.add(jPanel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(1187, 180, 80, 90));

        jPanel62.setBackground(new java.awt.Color(214, 214, 214));
        jPanel62.setMaximumSize(new java.awt.Dimension(80, 80));
        jPanel62.setMinimumSize(new java.awt.Dimension(80, 80));
        jPanel62.setLayout(null);

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calandar1.png"))); // NOI18N
        jButton12.setBorderPainted(false);
        jButton12.setContentAreaFilled(false);
        jButton12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calendar2.png"))); // NOI18N
        jPanel62.add(jButton12);
        jButton12.setBounds(0, 0, 80, 70);

        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setText("Expire Dates");
        jPanel62.add(jLabel68);
        jLabel68.setBounds(0, 61, 80, 30);

        jPanel31.add(jPanel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(1103, 180, 80, 90));

        jPanel27.setBackground(new java.awt.Color(214, 214, 214));
        jPanel27.setMaximumSize(new java.awt.Dimension(80, 80));
        jPanel27.setMinimumSize(new java.awt.Dimension(80, 80));
        jPanel27.setLayout(null);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search1.png"))); // NOI18N
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search2.png"))); // NOI18N
        jPanel27.add(jButton5);
        jButton5.setBounds(0, 0, 80, 70);

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Search Drug");
        jPanel27.add(jLabel30);
        jLabel30.setBounds(0, 61, 80, 30);

        jPanel31.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 180, 80, 90));

        jPanel67.setBackground(new java.awt.Color(214, 214, 214));
        jPanel67.setMaximumSize(new java.awt.Dimension(80, 80));
        jPanel67.setMinimumSize(new java.awt.Dimension(80, 80));
        jPanel67.setLayout(null);

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Print-icon2.png"))); // NOI18N
        jButton19.setBorderPainted(false);
        jButton19.setContentAreaFilled(false);
        jButton19.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Print-icon3.png"))); // NOI18N
        jPanel67.add(jButton19);
        jButton19.setBounds(0, 0, 80, 70);

        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setText("Print");
        jPanel67.add(jLabel73);
        jLabel73.setBounds(10, 61, 60, 30);

        jPanel31.add(jPanel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 80, 80, 90));

        jPanel66.setBackground(new java.awt.Color(214, 214, 214));
        jPanel66.setMaximumSize(new java.awt.Dimension(80, 80));
        jPanel66.setMinimumSize(new java.awt.Dimension(80, 80));
        jPanel66.setLayout(null);

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Print-icon2.png"))); // NOI18N
        jButton16.setBorderPainted(false);
        jButton16.setContentAreaFilled(false);
        jButton16.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Print-icon3.png"))); // NOI18N
        jPanel66.add(jButton16);
        jButton16.setBounds(0, 0, 80, 70);

        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setText("Print");
        jPanel66.add(jLabel72);
        jLabel72.setBounds(10, 61, 60, 30);

        jPanel31.add(jPanel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(1187, 80, 80, 90));

        jPanel65.setBackground(new java.awt.Color(214, 214, 214));
        jPanel65.setMaximumSize(new java.awt.Dimension(80, 80));
        jPanel65.setMinimumSize(new java.awt.Dimension(80, 80));
        jPanel65.setLayout(null);

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Print-icon2.png"))); // NOI18N
        jButton15.setBorderPainted(false);
        jButton15.setContentAreaFilled(false);
        jButton15.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Print-icon3.png"))); // NOI18N
        jPanel65.add(jButton15);
        jButton15.setBounds(0, 0, 80, 70);

        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setText("Print");
        jPanel65.add(jLabel71);
        jLabel71.setBounds(10, 61, 60, 30);

        jPanel31.add(jPanel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(1103, 80, 80, 90));

        jPanel61.setBackground(new java.awt.Color(214, 214, 214));
        jPanel61.setMaximumSize(new java.awt.Dimension(80, 80));
        jPanel61.setMinimumSize(new java.awt.Dimension(80, 80));
        jPanel61.setLayout(null);

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/User-icon1.png"))); // NOI18N
        jButton11.setBorderPainted(false);
        jButton11.setContentAreaFilled(false);
        jButton11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/User-icon2.png"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel61.add(jButton11);
        jButton11.setBounds(0, 0, 80, 70);

        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel67.setText("Admin Panel");
        jPanel61.add(jLabel67);
        jLabel67.setBounds(10, 61, 60, 30);

        jPanel31.add(jPanel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 80, 80, 90));

        jPanel1.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        if (!jTextField6.getText().equals("")) {
            jButton1.grabFocus();
            try {
                Double.parseDouble(jTextField6.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please insert into numerics");
                jTextField6.grabFocus();
                jTextField6.setText("");
            }
        } else {
            jTextField6.grabFocus();
        }


    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
        int i = jTable3.getSelectedRow();
        String f = "" + i;
        if (f != null) {
            int g = JOptionPane.showConfirmDialog(null, "Are you sure want to remove Item");
            if (g == JOptionPane.YES_OPTION) {
                dtm.removeRow(i);
                tablePaymentTotal();
            }
        }
    }//GEN-LAST:event_jTable3MouseClicked

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        DefaultTableModel tb1 = (DefaultTableModel) jTable3.getModel();

        double Price = Double.parseDouble(jTextField3.getText());
        double amount = Double.parseDouble(jTextField2.getText());
        double discount = Double.parseDouble(jTextField6.getText());
        double itemAmount = Price * amount;

        double disAmount = (discount * itemAmount) / 100;

        double itemamountMinusDis = itemAmount - disAmount;

        Vector v = new Vector();
        v.add(drug_id);
        v.add(jTextField1.getText());
        v.add(jTextField2.getText());
        v.add(unitPrice);
        v.add(jTextField6.getText());
        v.add(itemamountMinusDis);
        tb1.addRow(v);

        tablePaymentTotal();

        drug_id = "";
        unitPrice = "";

        jTextField1.setText("");
        jLabel1.setText("");
        jTextField2.setText("");
        jTextField6.setText("0");
        jTextField3.setText("");
        jTextField1.grabFocus();

    }//GEN-LAST:event_jButton1KeyPressed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        if (!jTextField2.getText().equals("")) {
            jTextField6.grabFocus();
            try {
                Double.parseDouble(jTextField2.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please insert into numerics");
                jTextField2.grabFocus();
                jTextField2.setText("");
            }
        } else {
            jTextField2.grabFocus();
        }


    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        DefaultTableModel dtm = (DefaultTableModel) jTable10.getModel();

        if (jTextField1.getText().trim().length() != 0) {
            try {
                List<Drug> drug = DrugController.searchDrugByName(jTextField1.getText().trim());

                dtm.setRowCount(0);
                Batch batch;
                if (drug != null) {
                    for (int i = 0; i < drug.size(); i++) {

                        batch = BatchController.getOldBatch(drug.get(i).getDrug_id());

                        Vector v = new Vector();
                        v.add(drug.get(i).getDrug_name());
                        v.add(drug.get(i).getDrug_id());
                        v.add(drug.get(i).getDrug_generic_name());

                        v.add(drug.get(i).getBrand_id().getBrand_name());
                        v.add(batch.getBatch_unit_cost());
                        v.add(batch.getBatch_unit_price());
                        v.add(batch.getBatch_unit_price());
                        v.add(batch.getBatch_exp_date());
                        dtm.addRow(v);
                        jPanel7.setVisible(true);
                        jScrollPane6.setVisible(true);
                        jTable10.setVisible(true);

                    }

                    if (dtm.getRowCount() == 0) {
                        jPanel7.setVisible(false);
                        jScrollPane6.setVisible(false);
                        jTable10.setVisible(false);
                    } else {
                        jPanel7.setVisible(true);
                        jScrollPane6.setVisible(true);
                        jTable10.setVisible(true);
                    }
                }
                drug = null;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CreateInvoice.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CreateInvoice.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            dtm.setRowCount(0);
            jPanel7.setVisible(false);
            jScrollPane6.setVisible(false);
            jTable10.setVisible(false);
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (evt.getKeyCode() == 40) {
            if (jTextField1.getText().length() != 0) {
                jTable10.grabFocus();
                ListSelectionModel selectionModel = jTable10.getSelectionModel();
                selectionModel.setSelectionInterval(0, 0);
            } else {
                jPanel7.setVisible(false);
                jScrollPane6.setVisible(false);
                jTable10.setVisible(false);
            }

        } else if (evt.getKeyCode() == 27) {
            jRadioButton1.setSelected(true);
            jTextField12.grabFocus();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTable10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable10KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable10KeyReleased

    private void jTable10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable10KeyPressed
        if (evt.getKeyCode() == 10) {
            try {

                int Row = jTable10.getSelectedRow();
                jTextField1.setText(jTable10.getValueAt(Row, 0).toString());
                drug_id = jTable10.getValueAt(Row, 1).toString();

                unitPrice = jTable10.getValueAt(Row, 5).toString();

                Drug drug = DrugController.searchByDrugId(drug_id);
                jLabel1.setText(drug.getDrug_generic_name());
                //                jTextField2.setText(drug.getDrug_generic_name());
                jTextField3.setText(unitPrice);
                jTextField2.grabFocus();

                jPanel7.setVisible(false);
                jScrollPane6.setVisible(false);
                jTable10.setVisible(false);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }//GEN-LAST:event_jTable10KeyPressed

    private void jTable10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable10MousePressed

    }//GEN-LAST:event_jTable10MousePressed

    private void jTable10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable10MouseClicked
        DefaultTableModel dtm = (DefaultTableModel) jTable10.getModel();
        int row = jTable10.getSelectedRow();
        String centerId = dtm.getValueAt(row, 1).toString();

        System.out.println("asdasd: " + centerId);

        ProductBatch dialog = new ProductBatch(new javax.swing.JFrame(), true, centerId);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_jTable10MouseClicked

    private void jTable11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable11MouseClicked

    private void jTable11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable11MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable11MousePressed

    private void jTable11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable11KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable11KeyPressed

    private void jTable11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable11KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable11KeyReleased

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5KeyPressed

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2KeyPressed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable4MouseClicked

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        LoginPos dialog = new LoginPos(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        jTextField2.selectAll();
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained
        jTextField2.selectAll();
    }//GEN-LAST:event_jTextField2FocusGained

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        char vChar = evt.getKeyChar();
        if (jTextField10.getText().equals("")) {
            dot = false;
        }
        if (dot == false) {
            if (vChar == '.') {
                dot = true;
            } else if (!(Character.isDigit(vChar)
                    || (vChar == KeyEvent.VK_BACK_SPACE)
                    || (vChar == KeyEvent.VK_DELETE))) {
                evt.consume();
            }
        } else if (!(Character.isDigit(vChar)
                || (vChar == KeyEvent.VK_BACK_SPACE)
                || (vChar == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
        char vChar = evt.getKeyChar();
        if (jTextField6.getText().equals("")) {
            dot = false;
        }
        if (dot == false) {
            if (vChar == '.') {
                dot = true;
            } else if (!(Character.isDigit(vChar)
                    || (vChar == KeyEvent.VK_BACK_SPACE)
                    || (vChar == KeyEvent.VK_DELETE))) {
                evt.consume();
            }
        } else if (!(Character.isDigit(vChar)
                || (vChar == KeyEvent.VK_BACK_SPACE)
                || (vChar == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField6KeyTyped

    private void jTextField6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField6FocusGained
        jTextField6.selectAll();
    }//GEN-LAST:event_jTextField6FocusGained

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        try {
            //           Category cattegory = CategoryController.getCategory_id_byName(jComboBox2.getSelectedItem().toString());
//        Brand brand = BrandController.getBrand_id_byName(jComboBox1.getSelectedItem().toString());
//
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();

            String datef = dateFormat.format(date);
            System.out.println(dateFormat.format(date)); //2016/11/16 12:08:4

            String payMethod = "";
            if (jRadioButton1.isSelected()) {
                payMethod = "Cash";

            }
            User user = UserController.getUserById(1);
            double discount = 0;
            if (!jTextField11.getText().equals("")) {
                discount = Double.parseDouble(jTextField11.getText());
            } else {
                discount = 0;
            }
            Customer customer = CustomerController.searchCustomerByNameDefault("Default");
            Invoice invoice = new Invoice(null, jLabel4.getText(), datef, discount, Double.parseDouble(jLabel7.getText()), payMethod, Double.parseDouble(jLabel79.getText()), Double.parseDouble(jLabel81.getText()), 0, datef, datef, user, customer);

            int isAdded = InvoiceController.save(invoice);

            int getMaxId = InvoiceController.getMaxId();

            DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
            int rowCount = dtm.getRowCount();

            InvoiceLine ivoiceLine;
            double itemQuantity = 0;
            double itemPrice = 0;
            double itemDiscount = 0;
            double itemAmount = 0;
            int isAddInvoiceLine = 0;

            int drug_id = 0;
            for (int i = 0; i < rowCount; i++) {

                drug_id = Integer.parseInt(dtm.getValueAt(i, 0).toString());
                itemQuantity = Double.parseDouble(dtm.getValueAt(i, 2).toString());
                itemPrice = Double.parseDouble(dtm.getValueAt(i, 3).toString());
                itemDiscount = Double.parseDouble(dtm.getValueAt(i, 4).toString());
                itemAmount = Double.parseDouble(dtm.getValueAt(i, 5).toString());
                System.out.println("" + getMaxId + " " + drug_id);
                ivoiceLine = new InvoiceLine(null, itemQuantity, itemPrice, itemDiscount, itemAmount, (getMaxId-1), drug_id);
                isAddInvoiceLine = InvoiceLineController.save(ivoiceLine);
            }

            String formatted = String.format("%06d", getMaxId);
            jLabel4.setText("" + formatted);
            jTextField1.grabFocus();
            
            dtm.setRowCount(0);
            jLabel7.setText("0.00");
            jLabel82.setText("0.00");
            jLabel77.setText("0.00");
            jLabel79.setText("0.00");
            jLabel81.setText("0.00");
            jTextField12.setText("0");
            jTextField11.setText("");
            jRadioButton1.setSelected(false);
            jLabel75.setText("");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateInvoice.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CreateInvoice.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton6ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jTextField11FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField11FocusGained
        jTextField3.setText("");
    }//GEN-LAST:event_jTextField11FocusGained

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed

//        DecimalFormat df = new DecimalFormat("00.00");
//
//        double netVal = Double.parseDouble(jLabel17.getText());
//        double discRate = Double.parseDouble(jTextField3.getText());
//        setNetDisc = netVal * discRate / 100;
//        jLabel40.setText(df.format(setNetDisc).toString());
//        double totalLineDisc = Double.parseDouble(jLabel37.getText());
//        totalDiscAmount = setNetDisc + totalLineDisc;
//        jLabel42.setText(df.format(totalDiscAmount).toString());
//        jLabel31.setText(df.format(tot - totalDiscAmount).toString());
//        jTextField7.grabFocus();
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyPressed

        if (evt.getKeyCode() == 116) {
            jRadioButton1.setSelected(true);
            jTextField8.setText("Cash");
            jTextField3.grabFocus();
        } else if (evt.getKeyCode() == 117) {
            jRadioButton2.setSelected(true);
            jTextField8.setText("Cheque");
            jTextField3.grabFocus();
        } else if (evt.getKeyCode() == 118) {
            jRadioButton3.setSelected(true);
            jTextField8.setText("Credit");
            jTextField3.grabFocus();
        } else if (evt.getKeyCode() == 27) {
            jRadioButton1.setSelected(true);
            jTextField12.grabFocus();
        }
    }//GEN-LAST:event_jTextField11KeyPressed

    private void jTextField12FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField12FocusGained
        jTextField12.selectAll();
    }//GEN-LAST:event_jTextField12FocusGained

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        jRadioButton1.setSelected(true);
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyPressed
        jRadioButton1.setSelected(true);
    }//GEN-LAST:event_jTextField12KeyPressed

    private void jTextField11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyTyped
        System.out.println(evt.getKeyCode());


    }//GEN-LAST:event_jTextField11KeyTyped

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        if (evt.getKeyCode() == 27) {
            jRadioButton1.setSelected(true);
            jTextField12.grabFocus();
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyPressed
        if (evt.getKeyCode() == 27) {
            jRadioButton1.setSelected(true);
            jTextField12.grabFocus();
        }
    }//GEN-LAST:event_jTextField6KeyPressed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
        if (evt.getKeyCode() == 27) {
            jRadioButton1.setSelected(true);
            jTextField12.grabFocus();
        }
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jTextField12KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyTyped

    }//GEN-LAST:event_jTextField12KeyTyped

    private void jTextField12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyReleased
        if (evt.getKeyCode() == 27) {
            jRadioButton1.setSelected(true);
            jTextField12.grabFocus();
        }
        DecimalFormat df = new DecimalFormat("##.00");
        jLabel82.setText(jTextField12.getText());

        double payment = 0;
        if (!jTextField12.getText().equals("")) {
            payment = Double.parseDouble(jTextField12.getText());
        } else {
            payment = 0;
        }

        double total = Double.parseDouble(jLabel7.getText());
        double balance = payment - total;
        jLabel82.setText("" + df.format(balance).toString());
    }//GEN-LAST:event_jTextField12KeyReleased

    private void jTextField11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyReleased
        DecimalFormat df = new DecimalFormat("##.00");
        double payment = Double.parseDouble(jLabel77.getText());
        double discount = 0;
        if (!jTextField11.getText().equals("")) {
            discount = Double.parseDouble(jTextField11.getText());
        } else {
            discount = 0;
        }
        double payAmount = 0;
        if (!jTextField12.getText().equals("")) {
            payAmount = Double.parseDouble(jTextField12.getText());
        } else {
            payAmount = 0;
        }
//        double discount = Double.parseDouble(jTextField11.getText());
        double disAmount = (payment * discount) / 100;
        jLabel7.setText("" + df.format(payment - disAmount).toString());
        jLabel82.setText("" + df.format(payAmount - (payment - disAmount)).toString());
    }//GEN-LAST:event_jTextField11KeyReleased

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    try {
                        UIManager.setLookAndFeel(new SyntheticaBlueSteelLookAndFeel());
                    } catch (UnsupportedLookAndFeelException ex) {
                        Logger.getLogger(CreateInvoice.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    new CreateInvoice().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(CreateInvoice.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
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
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable11;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
