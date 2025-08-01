import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BoardingPass extends JFrame implements ActionListener {

    JTextField tfpnr;
    JLabel tfname, tfnationality, lblsrc, lbldes, lablefname, lablefcode, labeldate;
    JButton fetchButton;

    public BoardingPass() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("AIR INDIA");
        heading.setBounds(410, 10, 450, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(heading);

        JLabel subheading = new JLabel("Boarding Pass");
        subheading.setBounds(410, 50, 350, 30);
        subheading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        subheading.setForeground(Color.RED);
        add(subheading);

        JLabel lblname = new JLabel("NAME:");
        lblname.setBounds(60, 140, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);

        tfpnr = new JTextField();
        tfpnr.setBounds(220, 100, 150, 25);
        add(tfpnr);

        fetchButton = new JButton("Enter");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 100, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);


        JLabel lblaadhar = new JLabel("PNR DETAILS : ");
        lblaadhar.setBounds(60, 100, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);

        tfname = new JLabel();
        tfname.setBounds(220, 140, 150, 25);
        add(tfname);

        JLabel lblnationality = new JLabel("NATIONALITY : ");
        lblnationality.setBounds(60, 180, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);

        tfnationality = new JLabel();
        tfnationality.setBounds(220, 180, 150, 25);
        add(tfnationality);

        JLabel lbladdress = new JLabel("SRC : ");
        lbladdress.setBounds(60, 225, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);

        lblsrc = new JLabel();
        lblsrc.setBounds(220, 230, 150, 25);
        add(lblsrc);

        JLabel lblgender = new JLabel("DEST : ");
        lblgender.setBounds(400, 220, 100, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);

        lbldes = new JLabel();
        lbldes.setBounds(550, 220, 150, 25);
        add(lbldes);


        JLabel lblfname = new JLabel("FLIGHT NAME : ");
        lblfname.setBounds(60, 260, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);

        lablefname = new JLabel();
        lablefname.setBounds(220, 260, 150, 25);
        add(lablefname);

        JLabel lblfcode = new JLabel("FLIGHT CODE : ");
        lblfcode.setBounds(380, 260, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);

        lablefcode = new JLabel();
        lablefcode.setBounds(550, 260, 150, 25);
        add(lablefcode);

        JLabel lbldate = new JLabel("DATE : ");
        lbldate.setBounds(60, 300, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);

        labeldate = new JLabel();
        labeldate.setBounds(220, 300, 150, 25);
        add(labeldate);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/airindia.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);

        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(600, 0, 300, 300);
        add(lblimage);


        setSize(1000, 500);
        setLocation(300,150);
        setLocationRelativeTo(null); // ✅ Centers the window on screen
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

            String pnr = tfpnr.getText();

            try {
                Conn conn = new Conn();

                String query = "select * from reservation where PNR = '" + pnr + "'";

                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {
                    tfname.setText(rs.getString("name"));
                    tfnationality.setText(rs.getString("nationality"));
                    lblsrc.setText(rs.getString("src"));
                    lbldes.setText(rs.getString("des"));
                    lablefname.setText(rs.getString("flightname"));
                    lablefcode.setText(rs.getString("flightcode"));
                    labeldate.setText(rs.getString("ddate"));
                } else {
                    JOptionPane.showMessageDialog(null, "Please Enter Correct PNR ");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

    }
    public static void main (String[]args){
        new BoardingPass();
    }
}
