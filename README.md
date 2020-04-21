# Библиотека Вейвлет преобразований.
## 1. Теория.

В данной библиотеке реализовано преобразование Хаара. Оно обычно используется для сжатия, компрессии изображений.

### 1.1. Преобразование Хаара для одномерного массива.
Пусть имеется одномерный массив X (дискретный сигнал). Каждой соседней паре элементов 
![\large x_{i}](https://render.githubusercontent.com/render/math?math=%5Clarge%20x_%7Bi%7D) и 
![\large x_{i + 1}](https://render.githubusercontent.com/render/math?math=%5Clarge%20x_%7Bi%20%2B%201%7D)
ставятся в соответствие два числа 
![\large \frac{x_{2i} + x_{2i + 1}}{2}](https://render.githubusercontent.com/render/math?math=%5Clarge%20%5Cfrac%7Bx_%7B2i%7D%20%2B%20x_%7B2i%20%2B%201%7D%7D%7B2%7D)
и 
![\large \frac{x_{2i} - x_{2i + 1}}{2}](https://render.githubusercontent.com/render/math?math=%5Clarge%20%5Cfrac%7Bx_%7B2i%7D%20-%20x_%7B2i%20%2B%201%7D%7D%7B2%7D).
Пройдясь по циклу по всем элементам массива получаются два новых массива (сигнала). Массив 
![\large A = \{a_i\}](https://render.githubusercontent.com/render/math?math=%5Clarge%20A%20%3D%20%5C%7Ba_i%5C%7D)
представляющий собой на практике уменьшенную версию исходного изображения, и второй массив
![\large B= \{b_i\}](https://render.githubusercontent.com/render/math?math=%5Clarge%20B%3D%20%5C%7Bb_i%5C%7D)
представляющий собой информацию необходимую для восстановления исходного изображения.

### 1.2. Преобразование Хаара для  двумерного массива.
Двумерное преобразование Хаара - это результат поочередного использования одномерного преобразования к столбцам или строкам массива. Так, при применении, одномерного преобразования к строкам двумерного массива первая половина колонок будет содержать сжатое изображение, а вторая половина будет содержать информацию восстановления.
После применения преобразования на каждом столбце на этом же массиве получится исходное изображение уменьшенное в 4 раза.

## 2.Примеры.
### 2.1 Одномерный случай.
Пусть дан одномерный массив
![\large X= \{100, 150, 200, 250, 125, 50\}](https://render.githubusercontent.com/render/math?math=%5Clarge%20X%3D%20%5C%7B100%2C%20150%2C%20200%2C%20250%2C%20125%2C%2050%5C%7D)
Тогда после преобразования он будет выглядеть как ![\large X= \{125,  225, 125\}](https://render.githubusercontent.com/render/math?math=%5Clarge%20X%3D%20%5C%7B125%2C%20%20225%2C%20125%5C%7D).

## 3. Использование класса.
Пусть дана следующая картинка. 
![Оригинал картинки][original_image]

[original_image]: https://github.com/ONeilN/WaveletImageConversion/blob/master/src/main/resources/testimages/test.png "Оригинал картинки"

При помощи следующего кода
(создается экземпляр класса, указывается источник картинки, вид преобразования - прямой или обратный, и количество итераций):
```
File forwardInputFile = new File("src/main/resources/testimages/test.png");

BufferedImage forwardImage = imageInOut.inputImage(forwardInputFile);

WaveletImage waveletForwardImage = new WaveletBufferedImage(forwardImage, TransformType.FORWARD, WaveletType.HAAR, 2);

File forwardOutputFile = new File("src/main/resources/resultimages/haar.forward.test.png");

imageInOut.outputImage(waveletForwardImage.getTransformedImage(), forwardOutputFile, "png");
```

После двойного преобразования по строкам и по стобцам получаем преобразованную картинку.

![Преобразованная картинка][transformed_image]

[transformed_image]: https://github.com/ONeilN/WaveletImageConversion/blob/master/src/main/resources/testimages/haar.test.png "Преобразованная картинка"

Обратное преобразование
```
File reverseInputFile = new File("src/main/resources/testimages/haar.forward.test3.png");

BufferedImage reverseImage = imageInOut.inputImage(reverseInputFile);

WaveletImage waveletReverseImage = new WaveletBufferedImage(reverseImage, TransformType.REVERSE, WaveletType.HAAR, 2);

File reverseOutputFile = new File("src/main/resources/resultimages/haar.reverse.test3.png");

imageInOut.outputImage(waveletReverseImage.getTransformedImage(), reverseOutputFile, "png");
```
![Преобразованная картинка][back_transformed_image]

[back_transformed_image]: https://github.com/ONeilN/WaveletImageConversion/blob/master/src/main/resources/testimages/haar.reverse.test.png "Преобразованная картинка"

Для получения уменьшенной картинки без информации для её обратного восстаовления можно вызвать метод getCroppedImage который не принимает никаких аргументов.
```
File croppedOutputFile = new File("src/main/resources/resultimages/cropped.png");

imageInOut.outputImage(waveletForwardImage.getCroppedImage(), croppedOutputFile, "png");

```
![Обрезанная картинка][cropped_image]

[cropped_image]: https://github.com/ONeilN/WaveletImageConversion/blob/master/src/main/resources/testimages/cropped.png "Обрезанная картинка"
# 4. Предстоит сделать.
## 4.1. Типы сигналов.
На данный момент билиотека работает только с дискретными сигналами, то есть с изображениями представимыми в виде двумерных массивов.
В будущем было бы интересно рассмотреть возможность работы с векторными изображениями.
## 4.2 Типы изображений.
Некоторые виды изображений уже сжаты, и хоть и представляют из себя дискретный сигнал, но записан не как обычный двумерный массив, где каждый элемент отвечает за свой пиксель. В будущем возможно изучить данные форматы, и производить преобразования и на них.
# 5. Источники.

[Wikipedia][https://ru.wikipedia.org/wiki/Вейвлет_Хаара]

