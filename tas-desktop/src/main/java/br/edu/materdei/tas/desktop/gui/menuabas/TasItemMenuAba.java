
package br.edu.materdei.tas.desktop.gui.menuabas;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JPanel;


public class TasItemMenuAba extends javax.swing.JPanel {
    private Boolean selecionado;
    private final Color colorOn = new Color(188,64,34);
    private final Color colorOff = new Color(40,40,40);
    private JPanel toolBar;
     
       
    /** Creates new form TasItemMenu */
    public TasItemMenuAba() {
        initComponents();
        
        selecionado = false;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        divTop = new javax.swing.JPanel();
        divLeft = new javax.swing.JPanel();
        divRight = new javax.swing.JPanel();
        divBotom = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(252, 252, 252));
        setMaximumSize(new java.awt.Dimension(140, 29));
        setMinimumSize(new java.awt.Dimension(140, 29));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(140, 29));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        divTop.setBackground(new java.awt.Color(198, 198, 198));
        divTop.setOpaque(false);
        divTop.setPreferredSize(new java.awt.Dimension(400, 1));

        javax.swing.GroupLayout divTopLayout = new javax.swing.GroupLayout(divTop);
        divTop.setLayout(divTopLayout);
        divTopLayout.setHorizontalGroup(
            divTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        divTopLayout.setVerticalGroup(
            divTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        add(divTop, java.awt.BorderLayout.NORTH);

        divLeft.setBackground(new java.awt.Color(198, 198, 198));
        divLeft.setOpaque(false);
        divLeft.setPreferredSize(new java.awt.Dimension(1, 298));

        javax.swing.GroupLayout divLeftLayout = new javax.swing.GroupLayout(divLeft);
        divLeft.setLayout(divLeftLayout);
        divLeftLayout.setHorizontalGroup(
            divLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );
        divLeftLayout.setVerticalGroup(
            divLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        add(divLeft, java.awt.BorderLayout.WEST);

        divRight.setBackground(new java.awt.Color(198, 198, 198));
        divRight.setOpaque(false);
        divRight.setPreferredSize(new java.awt.Dimension(1, 298));

        javax.swing.GroupLayout divRightLayout = new javax.swing.GroupLayout(divRight);
        divRight.setLayout(divRightLayout);
        divRightLayout.setHorizontalGroup(
            divRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );
        divRightLayout.setVerticalGroup(
            divRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        add(divRight, java.awt.BorderLayout.EAST);

        divBotom.setBackground(new java.awt.Color(195, 198, 198));
        divBotom.setPreferredSize(new java.awt.Dimension(400, 1));

        javax.swing.GroupLayout divBotomLayout = new javax.swing.GroupLayout(divBotom);
        divBotom.setLayout(divBotomLayout);
        divBotomLayout.setHorizontalGroup(
            divBotomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        divBotomLayout.setVerticalGroup(
            divBotomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        add(divBotom, java.awt.BorderLayout.SOUTH);

        titulo.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        titulo.setForeground(new java.awt.Color(40, 40, 40));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("PRINCIPAL");
        add(titulo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        if (!selecionado) {
            setCursor(new Cursor(Cursor.HAND_CURSOR));
            titulo.setForeground(colorOn);
            java.awt.EventQueue.invokeLater(new Runnable(){     
                @Override
                public void run(){     
                    revalidate();  
                    repaint();     
                }              
            });
        }        
    }//GEN-LAST:event_formMouseMoved

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        if (!selecionado) {
            titulo.setForeground(colorOff);
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            java.awt.EventQueue.invokeLater(new Runnable(){     
                @Override
                public void run(){     
                    revalidate();  
                    repaint();     
                }              
            });
        }
    }//GEN-LAST:event_formMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        for (int i = 0; i  < this.getParent().getComponentCount(); i++) {
            TasItemMenuAba filho = (TasItemMenuAba) this.getParent().getComponent(i);
            filho.setSelecionado(false);                       
        }        
        
        this.setSelecionado(true);
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel divBotom;
    private javax.swing.JPanel divLeft;
    private javax.swing.JPanel divRight;
    private javax.swing.JPanel divTop;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables

    public void setTituloAba(String tituloAba) {
        titulo.setText(tituloAba);
    }

    public void setSelecionado(Boolean selecionado) {
        this.selecionado = selecionado;
        
        ajusteComps();
    }

    private void ajusteComps() {
        this.setOpaque(this.selecionado);
        divTop.setOpaque(this.selecionado);
        divLeft.setOpaque(this.selecionado);
        divRight.setOpaque(this.selecionado);
        divBotom.setOpaque(!this.selecionado);
        
        if (this.selecionado) {
            titulo.setForeground(this.colorOn);
        } else {
            titulo.setForeground(colorOff);
        }
        java.awt.EventQueue.invokeLater(new Runnable(){     
            @Override
            public void run(){     
                revalidate();  
                repaint();     
            }              
        });
    }
    public void setToolBar(JPanel toolBar) {
        this.toolBar = toolBar;
    }
}