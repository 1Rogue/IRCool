/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rel.rogue.ircool;

import rel.rogue.ircool.components.ChannelList;

/**
 *
 * @author Spencer
 */
public class MainGUI extends javax.swing.JFrame {
    
    private static org.pircbotx.PircBotX statuser = IRCool.getUser();
    org.pircbotx.PircBotX user = IRCool.getUser();
    private static Config settings = new Config();
    private static java.util.HashMap<org.pircbotx.Channel, Object[]> users = new java.util.HashMap<>();
    private static CommandHandler cmdHandler = new CommandHandler();
    private static rel.rogue.ircool.components.ChannelList chanList;

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
        setBackground(new java.awt.Color(204, 204, 255));

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

        chanList = new rel.rogue.ircool.components.ChannelList();
        jScrollPane1.setViewportView(chanList);
        jScrollPane1.setHorizontalScrollBar(null);

        userList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {"Loading..."};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(userList);

        textArea.setEditable(false);
        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
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
                        .addGap(18, 18, 18)
                        .addComponent(textField)))
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

        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
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

    private void textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldActionPerformed
        sendMsg();
    }//GEN-LAST:event_textFieldActionPerformed

    private void textFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldKeyPressed
        if (evt.getKeyCode()==38) {
            //textField.setText(rel.rogue.ircool.components.ChannelList.previousTextLine());
            Utils.printConsole("previousTextLine triggered");
        }
    }//GEN-LAST:event_textFieldKeyPressed

    private void funButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_funButtonItemStateChanged
        switch (evt.getStateChange()) {
            case 0:
                IRCool.reconnectServ();
                rel.rogue.ircool.components.ChannelList.setChansRC();
                break;
            case 1:
                rel.rogue.ircool.components.ChannelList.setChansDC();
                IRCool.disconnectServ();
                break;
            default:
                Utils.printConsole("FunButton Error");
                break;
        }
    }//GEN-LAST:event_funButtonItemStateChanged

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        user.disconnect();
        IRCool.shutdown(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
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
            if (text.startsWith("/")/* && (text.length() > 1)*/) {
                //TO-DO Link to CommandHandler
                cmdHandler.parseCommand(text);
                //Utils.printCurrent("Command recognized");
            }
            else {
                user.sendMessage(rel.rogue.ircool.components.ChannelList.getActiveChannel(), text);
                Utils.printMsg(rel.rogue.ircool.components.ChannelList.getActiveChannel(), user.getNick(), text);
            }
            textField.setText("");
        }
    }
    /*public static void addUser (org.pircbotx.Channel chan, String user) {
        Object[] temp = users.get(chan);
        Object[] newlist = new Object[temp.length+1];
        System.arraycopy(temp, 0, newlist, 0, temp.length);
        newlist[newlist.length-1] = user;
        users.put(chan, newlist);
        updateUserList();
    }
    public static void removeUser (org.pircbotx.Channel chan, String user) {
        Object[] temp = users.get(chan);
        Object[] newlist = new Object[temp.length+1];
        System.arraycopy(temp, 0, newlist, 0, temp.length);
        newlist[newlist.length-1] = user;
        users.put(chan, newlist);
        updateUserList();
    }*/
    public static void clearUsers (org.pircbotx.Channel chan) {
        if (chanList.getChannelList().getSelectedValue().toString().equals(chan.getName())) {
            getUserList().setListData(new Object[]{""});
        }
        users.put(chan, new Object[]{""});
    }
    public static javax.swing.JTextArea getTextArea() {
        return textArea;
    }
    public static javax.swing.JList getUserList() {
        return userList;
    }
    /*public static void updateUserList() {
        System.out.println("I've been called! -updateUserList");
        userList.setModel(new javax.swing.AbstractListModel() {
            Object[] strings = users.get(Utils.getChan(activeChan));
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) {
                if(Utils.isOP(activeChan, strings[i].toString())) {
                    strings[i] = "@" + strings[i].toString();
                }
                if(Utils.isVoice(activeChan, strings[i].toString())) {
                    strings[i] = "+" + strings[i].toString();
                }
                java.util.Arrays.sort(strings);
                return strings[i];
            }
        });
    }*/
    public static void setUsers() {
        Object[] put = rel.rogue.ircool.parsers.ChannelParser.getChannelUsers(Utils.getChan(rel.rogue.ircool.components.ChannelList.getActiveChannel()).getUsers());
        java.util.Arrays.sort(put);
        //TODO finish sorting by ops/voiced/etc.
        /*java.util.List ops = new java.util.LinkedList();
        java.util.List voiced = new java.util.LinkedList();
        java.util.List users = new java.util.LinkedList();
        for(Object person : put) {
            if(Utils.isOP(activeChan, person.toString())) {
                ops.add(person);
            }
            else if(Utils.isVoice(activeChan, person.toString())) {
                voiced.add(person);
            }
            else {
                users.add(person);
            }
        }
        Object[] newlist = new Object[(ops.size()) + (voiced.size()) + (users.size()) - 1];
        Object[] newops = ops.toArray(put);
        java.util.Arrays.sort(newops);
        Object[] newvoiced = voiced.toArray(put);
        java.util.Arrays.sort(newvoiced);
        Object[] newusers = users.toArray(put);
        java.util.Arrays.sort(newusers);
        System.arraycopy(newops, 0, newlist, 0, newlist.length);
        System.arraycopy(newvoiced, 0, newlist, (ops.size()-1), newlist.length);
        System.arraycopy(newusers, 0, newlist, (ops.size()+voiced.size()-1), newlist.length);
        getUserList().setListData(newlist);*/
        getUserList().setListData(put);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private static javax.swing.JList userList;
    // End of variables declaration//GEN-END:variables
}
