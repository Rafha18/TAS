package br.edu.materdei.tas.desktop.gui.core;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.Icon;
import javax.swing.JPanel;


public class TasItemToolBar extends JPanel {
    private final Color foreOn = new Color(188,64,34);
    private final Color foreOff = new Color(40,40,40);
    
    private final Color backOff = new Color(252,252,252);
    private final Color backOn = new Color(253,229,221);
    
    private boolean selected;
    
    /**
     * Creates new form TasItemToolBar
     */
    public TasItemToolBar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        icone = new javax.swing.JLabel();
        label = new javax.swing.JLabel();

        setBackground(new java.awt.Color(252, 252, 252));
        setMaximumSize(new java.awt.Dimension(85, 50));
        setMinimumSize(new java.awt.Dimension(85, 50));
        setPreferredSize(new java.awt.Dimension(85, 50));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });

        icone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icone.setMaximumSize(new java.awt.Dimension(47, 45));
        icone.setMinimumSize(new java.awt.Dimension(47, 45));
        icone.setPreferredSize(new java.awt.Dimension(47, 35));
        add(icone);

        label.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        label.setText("jLabel1");
        add(label);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        if (isEnabled()&&(!selected)) {
            focado();
        }
    }//GEN-LAST:event_formMouseMoved

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        if (isEnabled()&&(!selected)) {
            normal();
        }
    }//GEN-LAST:event_formMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icone;
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables

    private void normal() {
        this.setBackground(backOff);
        label.setForeground(foreOff);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        java.awt.EventQueue.invokeLater(new Runnable(){     
            @Override
            public void run(){     
                revalidate();  
                repaint();     
            }              
        });
    }
    private void focado() {
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setBackground(backOn);
        label.setForeground(foreOn);
        java.awt.EventQueue.invokeLater(new Runnable(){     
            @Override
            public void run(){     
                revalidate();  
                repaint();     
            }              
        });
    }
    
    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        label.setEnabled(enabled);
        icone.setEnabled(enabled);
    }
    public void setIcon(Icon imagem) {
        icone.setIcon(imagem);
    }
    public void setLabel(String texto) {
        label.setText(texto);
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
        
        if (selected) { 
            focado();
            setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(188, 64, 34)));
        } else {
            normal();
            setBorder(null);
        }
    }
}