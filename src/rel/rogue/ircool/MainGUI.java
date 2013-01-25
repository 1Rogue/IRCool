/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rel.rogue.ircool;

/**
 *
 * @author Spencer
 */
public class MainGUI extends javax.swing.JFrame {
    
    org.pircbotx.PircBotX user = IRCool.getUser();
    private static Config settings = new Config();
    private static java.util.HashMap<String, String> channels = new java.util.HashMap<>();
    private static java.util.HashMap<org.pircbotx.Channel, Object[]> users = new java.util.HashMap<>();
    private static String activeChan = "#Rogue";
    private static CommandHandler cmdHandler = new CommandHandler();

    /**
     * Creates new form MainGUI
     */
    public MainGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        textField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        channelList = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        userList = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        funButton = new javax.swing.JToggleButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldActionPerformed(evt);
            }
        });
        textField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textFieldKeyPressed(evt);
            }
        });

        channelList.setModel(new javax.swing.AbstractListModel() {
            public int getSize() { return channels.size(); }
            public Object getElementAt(int i) {
                Object[] temp = channels.keySet().toArray();
                java.util.Arrays.sort(temp);
                if (temp[i].toString().equals("@@console")) {
                    temp[i] = (Object)user.getServer();

                }
                return temp[i];
            }
        });
        channelList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        channelList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        channelList.setName(""); // NOI18N
        channelList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                channelListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(channelList);

        userList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(userList);

        textArea.setEditable(false);
        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        textArea.setLineWrap(true);
        textArea.setRows(5);
        jScrollPane3.setViewportView(textArea);

        funButton.setText("Fun Button");
        funButton.setToolTipText("");
        funButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                funButtonItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(funButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(funButton)))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jMenu1.setText("File");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Exit");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        user.disconnect();
        System.exit(0);
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldActionPerformed
        sendMsg();
    }//GEN-LAST:event_textFieldActionPerformed

    private void textFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldKeyPressed
        if (evt.getKeyCode()==38) {
            //textField.setText(previousTextLine());
        }
    }//GEN-LAST:event_textFieldKeyPressed

    private void channelListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_channelListMouseClicked
        if (!(channelList.getSelectedValue().toString().equals(activeChan))) {
            channels.put(activeChan, getTextArea().getText());
            activeChan = channelList.getSelectedValue().toString();
            getTextArea().setText("");
            getTextArea().append(channels.get(activeChan));
            getTextArea().setCaretPosition(MainGUI.getTextArea().getDocument().getLength());
        }
    }//GEN-LAST:event_channelListMouseClicked

    private void funButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_funButtonItemStateChanged
        switch (evt.getStateChange()) {
            case 0:
                IRCool.reconnectServ();
                setChansRC();
                break;
            case 1:
                setChansDC();
                IRCool.disconnectServ();
                break;
            default:
                Utils.printConsole("FunButton Error");
                break;
        }
    }//GEN-LAST:event_funButtonItemStateChanged
    
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
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }
    
    
    private void sendMsg () {
        String text = textField.getText();
        if (!text.isEmpty()) {
            if (text.startsWith("/") && (text.length() > 1)) {
                //TO-DO Link to CommandHandler
                cmdHandler.parseCommand(text);
                //Utils.printCurrent("Command recognized");
            }
            else {
                user.sendMessage(activeChan, text);
                Utils.printMsg(activeChan, user.getNick(), text);
            }
            textField.setText("");
        }
    }
    
    public static void addChan (org.pircbotx.Channel chan) {
        channels.put(chan.getName(), "");
        users.put(chan, rel.rogue.ircool.Parsers.ChannelParser.getChannelUsers(chan.getUsers()));
    }
    public static javax.swing.JTextArea getTextArea() {
        return textArea;
    }
    public static javax.swing.JList getChannelList() {
        return channelList;
    }
    public static void updateChannelList() {
        channelList.setModel(new javax.swing.AbstractListModel() {
            public int getSize() { return channels.size(); }
            public Object getElementAt(int i) {
                Object[] temp = channels.keySet().toArray();
                java.util.Arrays.sort(temp);
                return temp[i];
            }
        });
    }
    public static void write (String channel, String message) {
        String temp = channels.get(channel);
        temp = temp + message;
        channels.put(channel, temp);
    }
    public static String getActiveChannel () {
        return activeChan;
    }
    
    public void setChansDC () {
        String[] chans = rel.rogue.ircool.Parsers.ChannelParser.getChannelNames(channels);
        for (int i=0;i<channels.size(); i++) {
            channels.put("(" + chans[i] + ")", channels.remove(chans[i]));
        }
    }
    
    public void setChansRC () {
        String[] chans = rel.rogue.ircool.Parsers.ChannelParser.getChannelNames(channels);
        String newkey = "";
        for (int i=0;i<channels.size(); i++) {
            newkey = chans[i].substring(1);
            newkey = chans[i].split("\\)")[0];
            channels.put("(" + chans[i] + ")", channels.remove(chans[i]));
        }
    }
   /* public void previousTextLine() {
        //TO-DO make a system for reteiving previous line of text based on channel
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JList channelList;
    private javax.swing.JToggleButton funButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private static javax.swing.JTextArea textArea;
    private javax.swing.JTextField textField;
    private javax.swing.JList userList;
    // End of variables declaration//GEN-END:variables
}
