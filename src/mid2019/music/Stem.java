package mid2019.music;

import java.awt.*;

public class Stem extends Duration {
    public Staff staff;
    public Head.List heads = new Head.List();
    public boolean isUp = true;

    public Stem(Staff staff, boolean up){
        this.staff = staff;
        this.isUp = up;
    }

    public void show(Graphics g){
        if(nFlag >= -1 && heads.size() > 0){
            int x = this.x(), h = staff.H(), yh = yFirstHead(), yb = yBeamEnd();
            g.drawLine(x, yh, x, yb);
        }
    }

    public void deleteStem(){ deleteMass(); }
    public void setWrongSides(){}    // stub

    public int yFirstHead(){
        Head h = firstHead();
        return h.staff.yLine(h.line);
    }
    public Head firstHead(){ return heads.get(isUp? heads.size()-1 : 0); }
    public Head lastHead(){return heads.get(isUp? 0: heads.size() - 1);}
    public int x(){Head h = firstHead(); return h.time.x + (isUp? h.w():0);}
    public int yBeamEnd(){  // based on music theory requirement
        Head h = lastHead();
        int line = h.line;
        line += isUp? -7 : 7;
        int flagInk = (nFlag > 2)? 2* nFlag - 2: 0;
        line += isUp? -flagInk : flagInk;
        if((isUp && line > 4) || (isUp && line < 4)){line = 4; }  // 4 is the center line
        return h.staff.yLine(line);
    }
}
