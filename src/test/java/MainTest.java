import org.example.draw.Drawing;
import org.example.draw.Window;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Math.min;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    Window window;

    @BeforeEach
    void setup(){
        window = new Window();
    }

    @Test
    void assertStartRadius(){
        assertEquals(100, window.getDrawing().getRealR());
    }

    @Test
    void assertWindowMinSize(){
        window.getMainFrame().setSize(100, 100);
        assertTrue(window.getMainFrame().getWidth() == 600 && window.getMainFrame().getHeight() == 600);
    }

    @Test
    void calcS(){
        window.getDrawing().setRealR(10000, window.getLabel2());
        assertEquals("426075,2457", String.format("%.4f", Drawing.findS(1000)));
    }

    @Test
    void outOfBounds(){
        window.getDrawing().setRealR(1000000, window.getLabel2());
        assertTrue(window.getDrawing().getR() / 4 <= min(
                window.getMainFrame().getWidth(),
                window.getMainFrame().getHeight())
        );
    }

    @Test
    void warningColorActivated(){
        window.getDrawing().setRealR(1000000, window.getLabel2());
        window.getDrawing().setR(window.getMainFrame(), window.getSpinner());

        assertSame(window.getSpinner().getEditor().getComponent(0).getBackground(), Drawing.warningColor);
    }

}
