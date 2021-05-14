

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;


public class Main {    
	 public static void main(String[] args) {
		 //Cargo la librería
		 System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		 //Contenedor objeto imagen
		 Mat imagen;
		 //Leo imagen desde el fichero
		 imagen = Imgcodecs.imread("lena.jpg");
		 
		 if(!imagen.empty()){
	            Image imagenMostrar = convertir(imagen);
	            int width=imagenMostrar.getWidth(null);
	            int height=imagenMostrar.getHeight(null);
	            Ventana ventana = new Ventana(imagenMostrar);
	            //Establezco los punto y dibujo rectángulo
	            Point point1 = new Point(200, 200);
	            Point point2 = new Point(100, 100);
	            Scalar color = new Scalar(120, 120, 120);
	            int thickness = 10;
	            Imgproc.rectangle (imagen, point1, point2, color, thickness);
	            //Saving and displaying the image
	            Imgcodecs.imwrite("arrowed_line.jpg", imagen);
	            HighGui.imshow("Seleccion rectángulo", imagen);
	            HighGui.waitKey();
		 }

	 }
	 

	private static Image convertir(Mat imagen) {
	        MatOfByte matOfByte = new MatOfByte();
	        Imgcodecs.imencode(".jpg", imagen, matOfByte); 
	 
	        byte[] byteArray = matOfByte.toArray();
	        BufferedImage bufImage = null;
	 
	        try {
	 
	            InputStream in = new ByteArrayInputStream(byteArray);
	            bufImage = ImageIO.read(in);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return (Image)bufImage;
	    }
}


