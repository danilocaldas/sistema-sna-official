/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sna.view;

import br.com.sna.control.PrincipalActionControl;

/**
 *
 * @author Danilo
 */
public class Principal extends javax.swing.JFrame {

    PrincipalActionControl principalActionControl;
    
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
        principalActionControl = new PrincipalActionControl(this);
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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuFuncionarios = new javax.swing.JMenuItem();
        menuPrestadores = new javax.swing.JMenuItem();
        menuProcedimentos = new javax.swing.JMenuItem();
        menuProducao = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Núcleo APAC/AIH");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 613, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 371, Short.MAX_VALUE)
        );

        jMenu1.setText("Iniciar");

        menuSair.setText("Sair");
        jMenu1.add(menuSair);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Cadastros");

        menuFuncionarios.setText("Funcionários");
        jMenu2.add(menuFuncionarios);

        menuPrestadores.setText("Prestadores");
        jMenu2.add(menuPrestadores);

        menuProcedimentos.setText("Procedimentos");
        jMenu2.add(menuProcedimentos);

        menuProducao.setText("Produção");
        jMenu2.add(menuProducao);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem menuFuncionarios;
    private javax.swing.JMenuItem menuPrestadores;
    private javax.swing.JMenuItem menuProcedimentos;
    private javax.swing.JMenuItem menuProducao;
    private javax.swing.JMenuItem menuSair;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JMenuItem getMenuFuncionarios() {
        return menuFuncionarios;
    }

    public void setMenuFuncionarios(javax.swing.JMenuItem menuFuncionarios) {
        this.menuFuncionarios = menuFuncionarios;
    }

    public javax.swing.JMenuItem getMenuPrestadores() {
        return menuPrestadores;
    }

    public void setMenuPrestadores(javax.swing.JMenuItem menuPrestadores) {
        this.menuPrestadores = menuPrestadores;
    }

    public javax.swing.JMenuItem getMenuProcedimentos() {
        return menuProcedimentos;
    }

    public void setMenuProcedimentos(javax.swing.JMenuItem menuProcedimentos) {
        this.menuProcedimentos = menuProcedimentos;
    }

    public javax.swing.JMenuItem getMenuSair() {
        return menuSair;
    }

    public void setMenuSair(javax.swing.JMenuItem menuSair) {
        this.menuSair = menuSair;
    }

    public javax.swing.JMenuItem getMenuProducao() {
        return menuProducao;
    }

    public void setMenuProducao(javax.swing.JMenuItem menuProducao) {
        this.menuProducao = menuProducao;
    }
    
    
}