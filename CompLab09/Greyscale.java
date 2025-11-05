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


public class Greyscale extends Transformation{
  public Greyscale() {
    // The constructor doesn't need to do anything.
  }

  // By overriding the doTransform function, the transform function will work automatically.

  @Override
  protected RGBColor doTransform(int x, int y, RGBColor originalColor, RGBImage image) {
    // Average the RGB value for the current pixel.
    // By setting the output color to rgb(avg, avg, avg), the output color is grey.
    int average = Math.round((originalColor.getRed() + originalColor.getGreen() + originalColor.getBlue()) / 3);
    return new RGBColor(average, average, average);
  }

};

