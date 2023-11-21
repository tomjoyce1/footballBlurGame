import java.awt.image.BufferedImage;
import java.awt.image.Kernel;
import java.awt.image.ConvolveOp;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import javax.imageio.ImageIO;

public class blur {
    public void blurImage(int radius) throws IOException {



String[] Picarray = { //"/Users/Thoma/OneDrive/Documents/Football/Alvarez.jpeg",
     //   "/Users/Thoma/OneDrive/Documents/Football/Bellingham.jpeg",
     //  "/Users/Thoma/OneDrive/Documents/Football/Benzema.jpeg",
    //    "/Users/Thoma/OneDrive/Documents/Football/Debruyne.jpeg",
      "/Users/Thoma/OneDrive/Documents/Football/Gundogan.jpeg",
        "/Users/Thoma/OneDrive/Documents/Football/Haaland.jpeg",
      //  "/Users/Thoma/OneDrive/Documents/Football/Lewandowski.jpeg",
    //    "/Users/Thoma/OneDrive/Documents/Football/Lionel.jpeg",
        //"/Users/Thoma/OneDrive/Documents/Football/Martinez.jpeg",
     //   "/Users/Thoma/OneDrive/Documents/Football/Mbappe.jpeg",
    //    "/Users/Thoma/OneDrive/Documents/Football/Odegaard.jpeg",
     //   "/Users/Thoma/OneDrive/Documents/Football/Osimhen.jpeg",
     //   "/Users/Thoma/OneDrive/Documents/Football/Rodri.jpeg",
     //   "/Users/Thoma/OneDrive/Documents/Football/Saka.jpeg",
      //  "/Users/Thoma/OneDrive/Documents/Football/Salah.jpeg",
    //    "/Users/Thoma/OneDrive/Documents/Football/Silva.jpeg",
    //    "/Users/Thoma/OneDrive/Documents/Football/Vinicius.jpeg",
};

        for(int i = 0; i< 2; i++) {

System.out.println("a");
            String filePath = Picarray[i];
            BufferedImage image = ImageIO.read(new File(filePath));

            //tom pad

            BufferedImage paddedImage = new BufferedImage(image.getWidth() + 2 * radius, image.getHeight() + 2 * radius, image.getType());
            paddedImage.getGraphics().drawImage(image, radius, radius, null);
            float[] data = new float[radius * radius];

            for (int k = 0; k < data.length; k++) {
                data[k] = 1f / (radius * radius);
            }
System.out.println("b");
            Kernel kernel = new Kernel(radius, radius, data);
            ConvolveOp blurOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
            BufferedImage blurredImage = blurOp.filter(image, null);

            blurredImage = blurredImage.getSubimage(radius, radius, blurredImage.getWidth() - 2 * radius, blurredImage.getHeight() - 2 * radius);


            String blurredImagePath = "/Users/Thoma/OneDrive/Documents/Blurred/" + i + ".jpg";
            ImageIO.write(blurredImage, "jpg", new File(blurredImagePath));
            System.out.println("c");

        }
    }


}
