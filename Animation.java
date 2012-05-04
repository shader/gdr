import java.util.*;

/**
 * Interface for animations. Contains one public method to load the animation sequence into an ArrayList.
 */
public interface Animation {
    public void Load(ArrayList<Effect> effects, Graph graph);
}