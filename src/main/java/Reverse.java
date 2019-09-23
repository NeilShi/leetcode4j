/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * <p>
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * <p>
 * 注意: 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Reverse {
    /**
     * 时间复杂度: O(log(x))
     * 空间复杂度: O(1)
     * */
    public int reverse(int x) {
        Integer param = new Integer(x);
        boolean endZero = false;
        char charArr[] = param.toString().toCharArray();
        int resultArrLen = charArr.length;
        while (charArr[resultArrLen - 1] == '0') {
            if (resultArrLen > 1) {
                endZero = true;
                resultArrLen--;
            } else {
                break;
            }
        }
        int index = 0;
        char resultArr[] = new char[resultArrLen];
        if (charArr[0] == '-') {
            resultArr[index++] = '-';
        }
        for (int i = charArr.length - 1; i > -1; i--) {
            if (charArr[i] == '0' && charArr.length > 1 && endZero) {
                continue;
            } else {
                endZero = false;
            }
            if (charArr[i] == '-') {
                break;
            }
            resultArr[index] = charArr[i];
            index++;
        }
        Long resultLong = Long.parseLong(new String(resultArr));
        if (resultLong < Math.pow(-2, 31) || resultLong > Math.pow(2, 31) - 1) {
            return 0;
        }
        return resultLong.intValue();
    }
}
