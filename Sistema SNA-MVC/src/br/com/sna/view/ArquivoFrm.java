/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sna.view;

import br.com.sna.control.ArquivoActionControl;
import br.com.sna.model.dao.Arquivo;
import br.com.sna.model.dao.Producao;
import br.com.sna.model.service.ArquivoImplements;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danilo
 */
public class ArquivoFrm extends javax.swing.JFrame {
    public DefaultTableModel tmArquivo = new DefaultTableModel(null, new String[]
    {"Numero","Ano","Mês","Cor" , "Prestador", "Procedimento"});
    ArquivoActionControl arquivoActionControl;
    ArquivoImplements arquivoImplements;
    List<Arquivo> arquivos;

    /**
     * Creates new form ArquivoFrm
     */
    public ArquivoFrm() {
        initComponents();
        arquivoActionControl = new ArquivoActionControl(this);
        arquivoImplements = new ArquivoImplements();
        searchArquivoGeral();
    }
    
    public final void searchArquivoGeral() {
        
        arquivos = arquivoImplements.lista_arquivo();
        mostrarArquivos(arquivos);
        
    }

    public void mostrarArquivos(List<Arquivo> arquivos) {
        while (tmArquivo.getRowCount() < 0) {
            tmArquivo.removeRow(0);
        }
        if (arquivos.size() == 0) {
            JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum registro!");
        } else {
            String[] campos = new String[]{null, null, null, null, null, null};
            for (int i = 0; i < arquivos.size(); i++) {
                tmArquivo.addRow(campos);
                tmArquivo.setValueAt(arquivos.get(i).getNumero(), i, 0);
                tmArquivo.setValueAt(arquivos.get(i).getAno(), i, 1);
                tmArquivo.setValueAt(arquivos.get(i).getMes(), i, 2);
                tmArquivo.setValueAt(arquivos.get(i).getCor(), i, 3);
                tmArquivo.setValueAt(arquivos.get(i).getPrestador_nome(), i, 4);
                tmArquivo.setValueAt(arquivos.get(i).getProcedimento_nome(), i, 5);

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

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ftxtNumeroIdentificao = new javax.swing.JFormattedTextField();
        txtAnoArquivamento = new com.toedter.calendar.JYearChooser();
        boxMesArquivamento = new com.toedter.calendar.JMonthChooser();
        boxCorCaixa = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jlistPrestadores = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        jlistProcedimentos = new javax.swing.JList();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTxConteudoPres = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        areaTxConteuProce = new javax.swing.JTextArea();
        jToolBar1 = new javax.swing.JToolBar();
        btIncluir = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btSalvar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btFinalizar = new javax.swing.JButton();
        btLimparProcedimento = new javax.swing.JToggleButton();
        btLimparPrestador = new javax.swing.JToggleButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Arquivo");

        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados da caixa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Numero de identificação:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Ano do arquivamento:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Mês do arquivamento:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Cor da caixa:");

        ftxtNumeroIdentificao.setEnabled(false);

        txtAnoArquivamento.setEnabled(false);

        boxMesArquivamento.setEnabled(false);

        boxCorCaixa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Amarelo", "Azul", "Branco", "Verde", "Vermelho", "Preto", "outros" }));
        boxCorCaixa.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(77, 77, 77)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(boxCorCaixa, 0, 95, Short.MAX_VALUE)
                    .addComponent(ftxtNumeroIdentificao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel5))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(boxMesArquivamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAnoArquivamento, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtAnoArquivamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(boxMesArquivamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ftxtNumeroIdentificao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxCorCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listagens", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jlistPrestadores.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlistPrestadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlistPrestadoresMouseClicked(evt);
            }
        });
        jlistPrestadores.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jlistPrestadoresValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(jlistPrestadores);

        jTabbedPane1.addTab("Prestadores", jScrollPane3);

        jlistProcedimentos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlistProcedimentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlistProcedimentosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlistProcedimentosMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(jlistProcedimentos);

        jTabbedPane1.addTab("Procedimentos", jScrollPane4);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Conteúdo adicionado na caixa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Prestador(s):");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Procedimento(s):");

        areaTxConteudoPres.setColumns(20);
        areaTxConteudoPres.setRows(5);
        areaTxConteudoPres.setEnabled(false);
        jScrollPane1.setViewportView(areaTxConteudoPres);

        areaTxConteuProce.setColumns(20);
        areaTxConteuProce.setRows(5);
        areaTxConteuProce.setEnabled(false);
        jScrollPane5.setViewportView(areaTxConteuProce);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane1, jScrollPane5});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane1, jScrollPane5});

        jToolBar1.setRollover(true);
        jToolBar1.setBorderPainted(false);

        btIncluir.setText("Incluir");
        btIncluir.setFocusable(false);
        btIncluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btIncluir.setMaximumSize(new java.awt.Dimension(93, 40));
        btIncluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btIncluir);

        btModificar.setText("Modificar");
        btModificar.setFocusable(false);
        btModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btModificar.setMaximumSize(new java.awt.Dimension(93, 40));
        btModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btModificar);

        btExcluir.setText("Excluir");
        btExcluir.setFocusable(false);
        btExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btExcluir.setMaximumSize(new java.awt.Dimension(93, 40));
        btExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btExcluir);
        jToolBar1.add(jSeparator1);

        btSalvar.setText("Salvar");
        btSalvar.setEnabled(false);
        btSalvar.setFocusable(false);
        btSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSalvar.setMaximumSize(new java.awt.Dimension(93, 40));
        btSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btSalvar);

        btAlterar.setText("Alterar");
        btAlterar.setEnabled(false);
        btAlterar.setFocusable(false);
        btAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btAlterar.setMaximumSize(new java.awt.Dimension(93, 40));
        btAlterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btAlterar);

        btFinalizar.setText("Finalizar");
        btFinalizar.setEnabled(false);
        btFinalizar.setFocusable(false);
        btFinalizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btFinalizar.setMaximumSize(new java.awt.Dimension(93, 40));
        btFinalizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btFinalizar);

        btLimparProcedimento.setText("Limpar Procedimento");
        btLimparProcedimento.setEnabled(false);

        btLimparPrestador.setText("Limpar Prestador");
        btLimparPrestador.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btLimparPrestador)
                                    .addComponent(btLimparProcedimento)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btLimparPrestador, btLimparProcedimento});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btLimparPrestador, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btLimparProcedimento)
                        .addGap(36, 36, 36))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)))
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btLimparPrestador, btLimparProcedimento});

        jTabbedPane2.addTab("Inclusão", jPanel1);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(tmArquivo);
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(295, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Manunteção", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlistPrestadoresValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jlistPrestadoresValueChanged

    }//GEN-LAST:event_jlistPrestadoresValueChanged

    private void jlistPrestadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlistPrestadoresMouseClicked
        StringBuilder buf = new StringBuilder();
        Object[] selectedValues = jlistPrestadores.getSelectedValues();
        for (int i = 0; i < selectedValues.length; i++) {
            buf.append(selectedValues[i].toString()).append(",\n");
        }
        areaTxConteudoPres.append(buf.toString());
    }//GEN-LAST:event_jlistPrestadoresMouseClicked

    private void jlistProcedimentosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlistProcedimentosMousePressed

    }//GEN-LAST:event_jlistProcedimentosMousePressed

    private void jlistProcedimentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlistProcedimentosMouseClicked
        StringBuilder buf = new StringBuilder();
        Object[] selectedValues = jlistProcedimentos.getSelectedValues();
        for (int i = 0; i < selectedValues.length; i++) {
            buf.append(selectedValues[i].toString()).append(",\n");
        }
        areaTxConteuProce.append(buf.toString());
    }//GEN-LAST:event_jlistProcedimentosMouseClicked

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
            java.util.logging.Logger.getLogger(ArquivoFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ArquivoFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ArquivoFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArquivoFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ArquivoFrm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTxConteuProce;
    private javax.swing.JTextArea areaTxConteudoPres;
    private javax.swing.JComboBox boxCorCaixa;
    private com.toedter.calendar.JMonthChooser boxMesArquivamento;
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btFinalizar;
    private javax.swing.JButton btIncluir;
    private javax.swing.JToggleButton btLimparPrestador;
    private javax.swing.JToggleButton btLimparProcedimento;
    private javax.swing.JButton btModificar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JFormattedTextField ftxtNumeroIdentificao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JList jlistPrestadores;
    private javax.swing.JList jlistProcedimentos;
    private com.toedter.calendar.JYearChooser txtAnoArquivamento;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JComboBox getBoxCorCaixa() {
        return boxCorCaixa;
    }

    public void setBoxCorCaixa(javax.swing.JComboBox boxCorCaixa) {
        this.boxCorCaixa = boxCorCaixa;
    }

    public com.toedter.calendar.JMonthChooser getBoxMesArquivamento() {
        return boxMesArquivamento;
    }

    public void setBoxMesArquivamento(com.toedter.calendar.JMonthChooser boxMesArquivamento) {
        this.boxMesArquivamento = boxMesArquivamento;
    }

    public javax.swing.JButton getBtAlterar() {
        return btAlterar;
    }

    public void setBtAlterar(javax.swing.JButton btAlterar) {
        this.btAlterar = btAlterar;
    }

    public javax.swing.JButton getBtExcluir() {
        return btExcluir;
    }

    public void setBtExcluir(javax.swing.JButton btExcluir) {
        this.btExcluir = btExcluir;
    }

    public javax.swing.JButton getBtFinalizar() {
        return btFinalizar;
    }

    public void setBtFinalizar(javax.swing.JButton btFinalizar) {
        this.btFinalizar = btFinalizar;
    }

    public javax.swing.JButton getBtIncluir() {
        return btIncluir;
    }

    public void setBtIncluir(javax.swing.JButton btIncluir) {
        this.btIncluir = btIncluir;
    }

    public javax.swing.JButton getBtModificar() {
        return btModificar;
    }

    public void setBtModificar(javax.swing.JButton btModificar) {
        this.btModificar = btModificar;
    }

    public javax.swing.JButton getBtSalvar() {
        return btSalvar;
    }

    public void setBtSalvar(javax.swing.JButton btSalvar) {
        this.btSalvar = btSalvar;
    }

    public javax.swing.JFormattedTextField getFtxtNumeroIdentificao() {
        return ftxtNumeroIdentificao;
    }

    public void setFtxtNumeroIdentificao(javax.swing.JFormattedTextField ftxtNumeroIdentificao) {
        this.ftxtNumeroIdentificao = ftxtNumeroIdentificao;
    }

    public javax.swing.JList getJlistPrestadores() {
        return jlistPrestadores;
    }

    public void setJlistPrestadores(javax.swing.JList jlistPrestadores) {
        this.jlistPrestadores = jlistPrestadores;
    }

    public javax.swing.JList getJlistProcedimentos() {
        return jlistProcedimentos;
    }

    public void setJlistProcedimentos(javax.swing.JList jlistProcedimentos) {
        this.jlistProcedimentos = jlistProcedimentos;
    }

    public com.toedter.calendar.JYearChooser getTxtAnoArquivamento() {
        return txtAnoArquivamento;
    }

    public void setTxtAnoArquivamento(com.toedter.calendar.JYearChooser txtAnoArquivamento) {
        this.txtAnoArquivamento = txtAnoArquivamento;
    }

    public javax.swing.JTextArea getAreaTxConteuProce() {
        return areaTxConteuProce;
    }

    public void setAreaTxConteuProce(javax.swing.JTextArea areaTxConteuProce) {
        this.areaTxConteuProce = areaTxConteuProce;
    }

    public javax.swing.JTextArea getAreaTxConteudoPres() {
        return areaTxConteudoPres;
    }

    public void setAreaTxConteudoPres(javax.swing.JTextArea areaTxConteudoPres) {
        this.areaTxConteudoPres = areaTxConteudoPres;
    }

    public javax.swing.JToggleButton getBtLimparPrestador() {
        return btLimparPrestador;
    }

    public void setBtLimparPrestador(javax.swing.JToggleButton btLimparPrestador) {
        this.btLimparPrestador = btLimparPrestador;
    }

    public javax.swing.JToggleButton getBtLimparProcedimento() {
        return btLimparProcedimento;
    }

    public void setBtLimparProcedimento(javax.swing.JToggleButton btLimparProcedimento) {
        this.btLimparProcedimento = btLimparProcedimento;
    }

    public DefaultTableModel getTmArquivo() {
        return tmArquivo;
    }

    public void setTmArquivo(DefaultTableModel tmArquivo) {
        this.tmArquivo = tmArquivo;
    }
    
    
}
