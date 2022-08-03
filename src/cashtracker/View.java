package cashtracker;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFileChooser;
import java.util.Date;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class View extends javax.swing.JFrame {

    public javax.swing.JMenuItem about;
    private javax.swing.JTextField changeField;
    private javax.swing.JLabel changeLabel;
    private javax.swing.JLabel clock;
    private javax.swing.JTextField creditField;
    private javax.swing.JLabel creditLabel;
    private javax.swing.JTextField customerField;
    private javax.swing.JLabel customerLabel;
    private javax.swing.JPanel entryPanel;
    private javax.swing.JTextField initialsField;
    private javax.swing.JLabel initialsLabel;
    private javax.swing.JLabel initialsLabel1;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox notesField;
    private javax.swing.JTextField paymentField;
    private javax.swing.JLabel paymentLabel;
    private java.awt.Button submitButton;
    private javax.swing.JTextField totalField;
    private javax.swing.JLabel totalLabel;
    public View() {
        
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/cashTracker/mygranthat.png")).getImage());
        
        //Clock Thread
        new Thread(){
            public void run(){
                while(true){
                    Calendar cal = new GregorianCalendar();
                    int hour = cal.get(Calendar.HOUR);
                    int min = cal.get(Calendar.MINUTE);
                    int sec = cal.get(Calendar.SECOND);
                    int AM_PM = cal.get(Calendar.AM_PM);
                    String ampm = "";
                    if(AM_PM == 1) ampm = "PM";
                    else ampm = "AM";
                    String time = hour + ":" + min + ":" + sec + " " + ampm;
                    clock.setText(time);
                }
            }
        }.start();
    }
    
    public void setMiddle(){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    }
    
    private static String getDate(){
        DateFormat dateFormat = new SimpleDateFormat("MM.dd.yyyy HH:mm");
	    Date date = new Date();
	    return (String) dateFormat.format(date);
    }
    
    //Calculate the change
    public void getChange(){
        try{
            double payment = Double.parseDouble(paymentField.getText());
            double credit = 0;
            if (creditField.getText().isEmpty()){
                credit = 0;
            } else {
                credit = Double.parseDouble(creditField.getText());
            }
            double total = Double.parseDouble(totalField.getText());
            double round = Math.round(((payment +credit) - total) * 100.0) / 100.0;
            changeField.setText(String.valueOf(round));
        } catch (NumberFormatException e) {
            changeField.setText("");
        }
    }
    
    //Produce the file name 
    public String getFileName(){
        DateFormat dateFormat = new SimpleDateFormat("MM.dd.yyyy HH꞉mm꞉ss");
	Date date = new Date();
        return customerField.getText() + " $" + totalField.getText() + " " + ((String) dateFormat.format(date)) + ".txt";
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        entryPanel = new javax.swing.JPanel();
        customerLabel = new javax.swing.JLabel();
        customerField = new javax.swing.JTextField();
        totalLabel = new javax.swing.JLabel();
        totalField = new javax.swing.JTextField();
        paymentLabel = new javax.swing.JLabel();
        paymentField = new javax.swing.JTextField();
        initialsField = new javax.swing.JTextField();
        initialsLabel = new javax.swing.JLabel();
        submitButton = new java.awt.Button();
        changeLabel = new javax.swing.JLabel();
        changeField = new javax.swing.JTextField();
        notesField = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        clock = new javax.swing.JLabel();
        creditLabel = new javax.swing.JLabel();
        creditField = new javax.swing.JTextField();
        initialsLabel1 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        about = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Will Call Cash Tracker");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        entryPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        entryPanel.setToolTipText("");
        customerLabel.setText("Customer:");
        customerField.setAutoscrolls(false);
        totalLabel.setText("Total:");
        totalField.setAutoscrolls(false);
        totalField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                totalFieldKeyReleased(evt);
            }
        });

        paymentLabel.setText("Cash:");
        paymentField.setAutoscrolls(false);
        paymentField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentFieldActionPerformed(evt);
            }
        });
        paymentField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                paymentFieldKeyReleased(evt);
            }
        });

        initialsField.setAutoscrolls(false);

        initialsLabel.setText("Initials:");

        submitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        submitButton.setLabel("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        changeLabel.setText("Change:");

        changeField.setEditable(false);
        changeField.setBackground(new java.awt.Color(255, 255, 255));
        changeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFieldActionPerformed(evt);
            }
        });

        notesField.setEditable(true);
        notesField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Gave change", "Left change", "Left Credit" }));
        notesField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notesFieldActionPerformed(evt);
            }
        });

        jLabel1.setToolTipText("");
        creditLabel.setText("Credit:");
        creditField.setAutoscrolls(false);
        creditField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditFieldActionPerformed(evt);
            }
        });
        creditField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                creditFieldKeyReleased(evt);
            }
        });

        initialsLabel1.setText("Notes:");

        javax.swing.GroupLayout entryPanelLayout = new javax.swing.GroupLayout(entryPanel);
        entryPanel.setLayout(entryPanelLayout);
        entryPanelLayout.setHorizontalGroup(
            entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(entryPanelLayout.createSequentialGroup()
                .addGroup(entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(entryPanelLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(customerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(entryPanelLayout.createSequentialGroup()
                                .addGroup(entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(initialsLabel)
                                    .addComponent(initialsLabel1)
                                    .addComponent(paymentLabel))
                                .addGap(23, 23, 23)
                                .addGroup(entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(customerField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(entryPanelLayout.createSequentialGroup()
                                        .addGap(69, 69, 69)
                                        .addComponent(jLabel1)
                                        .addGap(77, 77, 77))
                                    .addGroup(entryPanelLayout.createSequentialGroup()
                                        .addGroup(entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(initialsField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                                            .addComponent(paymentField, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(totalField))
                                        .addGap(18, 18, 18)
                                        .addComponent(creditLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(creditField, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(changeLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(changeField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(21, 21, 21))
                                    .addComponent(notesField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(entryPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(clock, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(entryPanelLayout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        entryPanelLayout.setVerticalGroup(
            entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, entryPanelLayout.createSequentialGroup()
                .addComponent(clock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(customerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paymentField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paymentLabel)
                    .addComponent(creditLabel)
                    .addComponent(creditField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeLabel))
                .addGap(18, 18, 18)
                .addGroup(entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(entryPanelLayout.createSequentialGroup()
                        .addComponent(initialsLabel1)
                        .addGroup(entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(entryPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(143, 143, 143))
                            .addGroup(entryPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(initialsLabel)
                                    .addComponent(initialsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(entryPanelLayout.createSequentialGroup()
                        .addComponent(notesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(entryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(entryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");

        about.setText("About");
        about.setToolTipText("");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        jMenu1.add(about);

        jMenuBar2.add(jMenu1);

        setJMenuBar(jMenuBar2);

        setSize(new java.awt.Dimension(503, 427));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Show pop up window of version information
    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        JOptionPane aboutPane = new JOptionPane("Version 1.0.0");
        aboutPane.showMessageDialog(null, "Version 1.0.0", "Version", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_aboutActionPerformed

    private void notesFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notesFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_notesFieldActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed

        //create the new saved file
        String fileName = getFileName();
        JFileChooser jFile = new JFileChooser();
        // this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING)); TESTING CODE, CLOSES PROGRAM
        File currentDir = jFile.getCurrentDirectory();
        File file = new File(currentDir, fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();

                //write to the file
                PrintWriter writer = new PrintWriter(currentDir + fileName, "UTF-8");
                writer.print("Customer: " + customerField.getText());
                writer.println("            Helped by: " + initialsField.getText());
                writer.println("Total: $ " + totalField.getText());
                writer.println("Cash: $ " + paymentField.getText());
                writer.println("Credit: $ " + creditField.getText());
                writer.println("Change: $ " + changeField.getText());
                writer.println("Notes: " + notesField.getSelectedItem());
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        creditField.setText("");
        notesField.setSelectedItem("");
        changeField.setText("");
        customerField.setText("");
        paymentField.setText("");
        totalField.setText("");
        initialsField.setText("");
    }//GEN-LAST:event_submitButtonActionPerformed

    private void paymentFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paymentFieldKeyReleased
        //determine change
        getChange();
    }

    private void paymentFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentFieldActionPerformed

    }//GEN-LAST:event_paymentFieldActionPerformed

    private void totalFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totalFieldKeyReleased
        //determine change
        getChange();
    }//GEN-LAST:event_totalFieldKeyReleased

    private void creditFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_creditFieldActionPerformed

    private void creditFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_creditFieldKeyReleased
        //determine change
        getChange();
    }//GEN-LAST:event_creditFieldKeyReleased

    private void changeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFieldActionPerformed
        // TODO add your handling code here:
    }

}
