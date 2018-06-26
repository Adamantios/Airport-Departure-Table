package basics;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;


public class MessageBoard extends javax.swing.JFrame {

    private static class displayLine {

        JLabel line;
        JLabel remarks;

        displayLine(JLabel Line, JLabel Remarks) {
            line = Line;
            remarks = Remarks;
        }
    }

    private static ArrayList<displayLine> displayLines = new ArrayList<>();
    private static FlightsTable ft;
    private final DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private final ScheduledExecutorService service;
    private boolean running = true;

    /**
     * Creates new form anouncementsTable
     */
    MessageBoard() {
        initComponents();

        displayLines.add(new displayLine(Line1, Remarks1));
        displayLines.add(new displayLine(Line2, Remarks2));
        displayLines.add(new displayLine(Line3, Remarks3));
        displayLines.add(new displayLine(Line4, Remarks4));
        displayLines.add(new displayLine(Line5, Remarks5));
        displayLines.add(new displayLine(Line6, Remarks6));
        displayLines.add(new displayLine(Line7, Remarks7));
        displayLines.add(new displayLine(Line8, Remarks8));
        displayLines.add(new displayLine(Line9, Remarks9));
        displayLines.add(new displayLine(Line10, Remarks10));

        // the display scheduler
        service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleWithFixedDelay(() -> {
            fillFlightsWallPanel();
            displayLines(ft);
            LabelInfo.setText(df.format(Utilities.getCurrentDateTime()));
            if (!running) {
                service.shutdown();
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    private static void fillFlightsWallPanel() {
        ArrayList<Flight> canceledFlights = AirLines.getCanceledFlights(Utilities.getCurrentDateTime());
        ArrayList<Flight> departedFlights = AirLines.getDepartedFligths(Utilities.getCurrentDateTime());
        ArrayList<Flight> otherFlights = AirLines.getOtherFligths();

        int i = 0;

        if (ft == null) {
            ft = new FlightsTable();
        } else {
            ft.clearTable();
        }

        if (!canceledFlights.isEmpty()) {
            for (Flight f : canceledFlights) {
                try {
                    ft.addFlight(f);
                } catch (Exception ex) {
                    Logger.getLogger(DemoGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
                if (i == 3) {
                    break;
                }
            }
        }

        i = 0;
        if (!departedFlights.isEmpty()) {
            for (Flight f : departedFlights) {
                try {
                    ft.addFlight(f);
                } catch (Exception ex) {
                    Logger.getLogger(DemoGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
                if (i == 2) {
                    break;
                }
            }
        }

        if (!otherFlights.isEmpty()) {
            for (Flight f : otherFlights) {
                try {
                    ft.addFlight(f);
                } catch (Exception ex) {
                    Logger.getLogger(DemoGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (ft.isFull()) {
                    break;
                }
            }
        }
    }

    private static void displayLines(FlightsTable theTableData) {
        Flight[] myTable = theTableData.getMyTable();
        for (int i = 0; i < 10; i++) {
            displayLines.get(i).line.setText(myTable[i].toString());
            if (myTable[i].toString().equals(" ")) {
                displayLines.get(i).remarks.setText(" ");
            } else {
                switch (myTable[i].getState()) {
                    case Boarding:
                        displayLines.get(i).remarks.setText("Boarding");
                        displayLines.get(i).remarks.setForeground(Color.ORANGE);
                        break;
                    case GatesClosed:
                        displayLines.get(i).remarks.setText("Gates Closed");
                        displayLines.get(i).remarks.setForeground(Color.GREEN);
                        break;
                    case Cancelled:
                        displayLines.get(i).remarks.setText("Canceled");
                        displayLines.get(i).remarks.setForeground(Color.RED);
                        break;
                    case Departed:
                        displayLines.get(i).remarks.setText("Departed");
                        displayLines.get(i).remarks.setForeground(Color.GREEN);
                        break;
                    case Delayed:
                        displayLines.get(i).remarks.setText("delayed");
                        displayLines.get(i).remarks.setForeground(Color.GREEN);
                        break;
                    case OnTime:
                        displayLines.get(i).remarks.setText("on time");
                        displayLines.get(i).remarks.setForeground(Color.GREEN);
                        break;
                }
            }
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

        jPanel1 = new javax.swing.JPanel();
        Header = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Line1 = new javax.swing.JLabel();
        Line2 = new javax.swing.JLabel();
        Line3 = new javax.swing.JLabel();
        Line4 = new javax.swing.JLabel();
        Line5 = new javax.swing.JLabel();
        Line6 = new javax.swing.JLabel();
        Line7 = new javax.swing.JLabel();
        Line8 = new javax.swing.JLabel();
        Line9 = new javax.swing.JLabel();
        Line10 = new javax.swing.JLabel();
        Remarks1 = new javax.swing.JLabel();
        Remarks2 = new javax.swing.JLabel();
        Remarks3 = new javax.swing.JLabel();
        Remarks4 = new javax.swing.JLabel();
        Remarks5 = new javax.swing.JLabel();
        Remarks6 = new javax.swing.JLabel();
        Remarks7 = new javax.swing.JLabel();
        Remarks8 = new javax.swing.JLabel();
        Remarks9 = new javax.swing.JLabel();
        Remarks10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        LabelInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Charokopeio University of Athens - Flights Management System");
        setAlwaysOnTop(true);
        setBackground(java.awt.Color.darkGray);
        setBounds(new java.awt.Rectangle(300, 600, 0, 0));
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        Header.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        Header.setForeground(new java.awt.Color(255, 255, 255));
        Header.setText("DEPARTURES                    AIRLINE        FLIGHT  VIA            EXPECTED DEPARTURE  SCHEDULED DEPARTURE REMARKS");
        Header.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Header)
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Header)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        Line1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        Line1.setForeground(new java.awt.Color(255, 255, 255));
        Line1.setText("display line");

        Line2.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        Line2.setForeground(new java.awt.Color(255, 255, 255));
        Line2.setText("display line");

        Line3.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        Line3.setForeground(new java.awt.Color(255, 255, 255));
        Line3.setText("display line");

        Line4.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        Line4.setForeground(new java.awt.Color(255, 255, 255));
        Line4.setText("display line");

        Line5.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        Line5.setForeground(new java.awt.Color(255, 255, 255));
        Line5.setText("display line");

        Line6.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        Line6.setForeground(new java.awt.Color(255, 255, 255));
        Line6.setText("display line");

        Line7.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        Line7.setForeground(new java.awt.Color(255, 255, 255));
        Line7.setText("display line");

        Line8.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        Line8.setForeground(new java.awt.Color(255, 255, 255));
        Line8.setText("display line");

        Line9.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        Line9.setForeground(new java.awt.Color(255, 255, 255));
        Line9.setText("display line");

        Line10.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        Line10.setForeground(new java.awt.Color(255, 255, 255));
        Line10.setText("display line");

        Remarks1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        Remarks1.setForeground(new java.awt.Color(255, 255, 255));
        Remarks1.setText("remarks");

        Remarks2.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        Remarks2.setForeground(new java.awt.Color(255, 255, 255));
        Remarks2.setText("remarks");

        Remarks3.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        Remarks3.setForeground(new java.awt.Color(255, 255, 255));
        Remarks3.setText("remarks");

        Remarks4.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        Remarks4.setForeground(new java.awt.Color(255, 255, 255));
        Remarks4.setText("remarks");

        Remarks5.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        Remarks5.setForeground(new java.awt.Color(255, 255, 255));
        Remarks5.setText("remarks");

        Remarks6.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        Remarks6.setForeground(new java.awt.Color(255, 255, 255));
        Remarks6.setText("remarks");

        Remarks7.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        Remarks7.setForeground(new java.awt.Color(255, 255, 255));
        Remarks7.setText("remarks");

        Remarks8.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        Remarks8.setForeground(new java.awt.Color(255, 255, 255));
        Remarks8.setText("remarks");

        Remarks9.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        Remarks9.setForeground(new java.awt.Color(255, 255, 255));
        Remarks9.setText("remarks");

        Remarks10.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        Remarks10.setForeground(new java.awt.Color(255, 255, 255));
        Remarks10.setText("remarks");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Line8)
                                        .addComponent(Line7)
                                        .addComponent(Line6)
                                        .addComponent(Line5)
                                        .addComponent(Line9)
                                        .addComponent(Line1)
                                        .addComponent(Line4)
                                        .addComponent(Line2)
                                        .addComponent(Line3)
                                        .addComponent(Line10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Remarks1)
                                        .addComponent(Remarks2)
                                        .addComponent(Remarks3)
                                        .addComponent(Remarks4)
                                        .addComponent(Remarks5)
                                        .addComponent(Remarks6)
                                        .addComponent(Remarks7)
                                        .addComponent(Remarks8)
                                        .addComponent(Remarks9)
                                        .addComponent(Remarks10))
                                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Line1)
                                        .addComponent(Remarks1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Line2)
                                        .addComponent(Remarks2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Line3)
                                        .addComponent(Remarks3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Line4)
                                        .addComponent(Remarks4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Line5)
                                        .addComponent(Remarks5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Line6)
                                        .addComponent(Remarks6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Line7)
                                        .addComponent(Remarks7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Line8)
                                        .addComponent(Remarks8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Line9)
                                        .addComponent(Remarks9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Line10)
                                        .addComponent(Remarks10))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(218, 142, 32));

        LabelInfo.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LabelInfo)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LabelInfo)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        running = false;
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(MessageBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MessageBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MessageBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MessageBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MessageBoard().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel Header;
    private javax.swing.JLabel LabelInfo;
    private static javax.swing.JLabel Line1;
    private static javax.swing.JLabel Line10;
    private static javax.swing.JLabel Line2;
    private static javax.swing.JLabel Line3;
    private static javax.swing.JLabel Line4;
    private static javax.swing.JLabel Line5;
    private static javax.swing.JLabel Line6;
    private static javax.swing.JLabel Line7;
    private static javax.swing.JLabel Line8;
    private static javax.swing.JLabel Line9;
    private static javax.swing.JLabel Remarks1;
    private static javax.swing.JLabel Remarks10;
    private static javax.swing.JLabel Remarks2;
    private static javax.swing.JLabel Remarks3;
    private static javax.swing.JLabel Remarks4;
    private static javax.swing.JLabel Remarks5;
    private static javax.swing.JLabel Remarks6;
    private static javax.swing.JLabel Remarks7;
    private static javax.swing.JLabel Remarks8;
    private static javax.swing.JLabel Remarks9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
