package mid2019.reaction;

import mid2019.I;

import java.awt.*;

public abstract class Mass extends Reaction.List implements I.Show{
    public Layer layer;
    public Mass (String layerName){
        this.layer = Layer.byName.get(layerName);
        if(layer != null){
            layer.add(this);
        }else{
            System.out.println("Bad layer name: " + layerName);
        }
    }
    public void deleteMass(){clearAll(); layer.remove(this);}
    // do nothing
    public void show(Graphics g){}
}
