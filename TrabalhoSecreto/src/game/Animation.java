package game;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Animation {
    private final Picture[] FlameAnimation;

    private final Picture[] WaterAnimation;

    private final Picture[] GrassAnimation;

    public Animation(int x,int y){
        FlameAnimation = new Picture[]{new Picture(x, y, "resources/firepower/1_resized.png"),
                new Picture(x,  y, "resources/firepower/2_resized.png"),
                new Picture(x, y, "resources/firepower/3_resized.png"),
                new Picture(x, y, "resources/firepower/4_resized.png"),
                new Picture(x, y, "resources/firepower/5_resized.png")};

        WaterAnimation = new Picture[]{new Picture(x, y, "resources/waterpowers/1_resized.png"),
                new Picture(x,y, "resources/waterpowers/2_resized.png"),
                new Picture(x,y, "resources/waterpowers/3_resized.png"),
                new Picture(x, y, "resources/waterpowers/4_resized.png"),
                new Picture(x, y, "resources/waterpowers/5_resized.png")};

        GrassAnimation = new Picture[]{new Picture(x, y, "resources/grasspowers/1_resized.png"),
                new Picture(x, y, "resources/grasspowers/2_resized.png"),
                new Picture(x, y, "resources/grasspowers/3_resized.png"),
                new Picture(x,y, "resources/grasspowers/4_resized.png"),
                new Picture(x, y, "resources/grasspowers/5_resized.png")};
    }


    public void drawFire() throws InterruptedException {
        for (Picture picture : FlameAnimation) {
            picture.draw();
            Thread.sleep(150);
            picture.delete();
        }
    }

    public void drawWater() throws InterruptedException {
        for (Picture picture : WaterAnimation) {
            picture.draw();
            Thread.sleep(150);
            picture.delete();
        }
    }

    public void drawGrass() throws InterruptedException {
        for (Picture picture : GrassAnimation) {
            picture.draw();
            Thread.sleep(150);
            picture.delete();
        }
    }

}
