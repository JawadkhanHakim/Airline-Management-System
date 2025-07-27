import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class JourneyDetails extends JFrame implements ActionListener {
    JTable table;
    TextField PNR;
    JButton show;

    public JourneyDetails(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblpnr = new JLabel("PNR Details");
        lblpnr.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblpnr.setBounds(50,50,100,25);
        add(lblpnr);

        PNR = new TextField();
        PNR.setBounds(160,50,120,25);
        add(PNR);

        show = new JButton("Show Details");
        show.setBackground(Color.BLACK);
        show.setForeground(Color.white);;
        show.setBounds(290,50,120,25);
        show.addActionListener(this);
        add(show);

        table = new JTable();


        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,800,150);
        jsp.setBackground(Color.WHITE);
        add(jsp);


        setSize(800,600);
        setLocation(250,150);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        try {
            Conn conn = new Conn();

            ResultSet rs = conn.s.executeQuery("select * from reservation where pnr = '"+PNR.getText()+"'");

            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null,"Invalid PNR");
                return;

            }
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        new JourneyDetails();
    }
}

