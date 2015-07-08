import java.util.List;
import java.util.ArrayList;
import java.awt.*;

public interface Level
{
    public void generate(List<Piece> pieces, List<Point> finalLocations, int[][] positions);
}
