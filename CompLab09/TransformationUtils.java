
/* Computer Lab 09: Image change
 *
 * Authors: Nikki Som, Shawn Grove, Leonard Jin
 *
 * Files in project:
 *     Transformation.java
 *     RGBImageUtil.java
 *     RGBImage.java
 *     RGBColor.java
 *     Tester.java
 *
 *     Greyscale.java
 *     Stamp.java
 *     AddBorder.java
 *     ColorPallet.java
 *     Brighten.java
 *     TransformationUtils.java
 */

public class TransformationUtils {
  // There is no constructor for this class since it only has a static method,
  // that is to say there is no state.

  public static void transformMany(Transformation[] transformations, String inputFile, String outputFile) {
    RGBImage image = RGBImageUtil.load(inputFile);

    for (int i = 0; i < transformations.length; i++) {
      // Apply every transformation to the image starting from the first.
      image = transformations[i].transform(image);
    }

    RGBImageUtil.saveImage(image, outputFile);
  }
}

