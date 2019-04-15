package com.test.collection;

/**
 * Created by Batman on 2018/8/2.
 */

/**
 * 排序工具类，里面包含各种排序方法
 */
public class SortCompare {
    /**
     * 名称：插入排序-直接插入排序
     * 描述：每次将一个待排序的元素与已排序的元素进行逐一比较，直到找到合适的位置按大小插入。
     * 时间复杂度：平均O(n^2)，最坏O(n^2)
     * 稳定性：稳定
     * @param array 待排数组
     */
    public void straightInsertionSort(int[] array){
        //取arr[0]作为初始的顺序序列，从arr[1]开始和顺序序列进行比较。
        for (int i = 1; i < array.length; i++) {
            //每次先与当前顺序序列的最大的数比，如果比他小则表示需要插入。
            // 如果比当前顺序序列里的最大数还要大，则不必插入，直接进行下一次循环。
            if(array[i] < array[i-1]){
                int temp = array[i];//先将待插数存入temp
                int j;

                //待插数据的前一个数其实就是当前顺序序列的最大数，所以先和前一个数比，
                // 如果比最大数小，则最大数后移一位，然后继续比。
                for(j = i-1; j >= 0 && array[j] > temp; j --){
                    array[j+1] = array[j];//把比temp大或相等的元素全部往后移动一个位置
                }
                array[j+1] = temp;//把待排序的元素temp插入腾出位置的(j+1)
            }
        }
    }

//================================================================================================
    /**
     * 名称：插入排序-希尔排序
     * 描述：把整个序列分成若干个子序列，分别进行直接插入排序。这算是“一趟希尔排序”
     * 时间复杂度：平均O(n^1.5)，最坏O(n^2)
     * 稳定性：不稳定
     * @param array 待排数组
     * @param incrementNum 初始增量
     */
    public void shellSort(int[] array,int incrementNum){
        //从初始增量开始循环，每次增量减少一倍
        for (int increment = incrementNum; increment > 0; increment /= 2) {
            //下面就是一个修改过的直接插入排序
            for (int i = increment; i < array.length; i++) {
                if(array[i] < array[i-increment]){
                    int temp = array[i];
                    int j;
                    for(j = i-increment; j >= 0 && array[j] > temp; j -=increment){
                        array[j+increment] = array[j];
                    }
                    array[j+increment] = temp;
                }
            }
        }
    }

//================================================================================================
    /**
     * 名称：交换排序-冒泡排序
     * 描述：第一趟，第一个和第二个比，第二个再和第三个比···，第一趟完后，最大的数会被排到最后。
     * 时间复杂度：平均O(n^2)，最坏O(n^2)
     * 稳定性：稳定
     * @param array 待排数组
     */
    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {//最多做n-1趟排序
            //随着i的一次次循环，j每次都少一次循环（因为后面的书都是排好序的）
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {    //如果前一位大于后一位，则把大的放前面
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

//================================================================================================
    /**
     * 名称：交换排序-快速排序
     * 描述：选第一个数作为“枢轴”，
     *      将枢轴与序列另一端的数比较，枢轴大于它，就换位，小于就再和另一端的倒数第二个数比较··
     *      第一次换位完了后依旧和另一边的比，但判断标准得颠倒，变成“如果枢轴小于它，就换位”
     *      一轮比完了，枢轴就到了中间，左边比它小，右边比它大。
     *      之后枢轴两边的序列继续进行快排。
     * 时间复杂度：平均O(nlogn)，最坏O(n^2)
     * 稳定性：不稳定
     * @param array 待排数组
     * @param low 开始位置（初始为0，因为一开始选[0]作为枢轴）
     * @param high 结束位置（初始为数组最后一个数）
     */
    public void quickSort(int[] array,int low,int high){
        int start = low;//开始位置（前端）
        int end = high;//结束位置（后端）
        int key = array[low];//关键值，也就是枢轴。第一次从位置0开始取，一轮排完会后排到中间。

        while(end>start){//
            //现在关键值在“前端”，从后往前比较，要找到小于关键值的值
            //如果比关键值大，则比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
            while(end>start&&array[end]>=key)
                end--;//如果最后一个值大于关键值，则end往前移一位，拿倒数第二个比···

            //由于之前的end--，现在是往前移了一位了，
            // 如果这时候刚好比关键值小，则将小的值和关键值交换位置。
            if(array[end]<=key){
                int temp = array[end];
                array[end] = array[start];
                array[start] = temp;
            }
            //现在关键值在后端，从前往后比较，要找到大于关键值的值
            //如果比关键值小，则比较下一个，直到有比关键值大的交换位置
            while(end>start&&array[start]<=key)

                //从前端开始找，如果前端的值比目前处在后端的关键值小，
                // 则start++，将前端位置往后移一位
                start++;
            //由于前端往后移了一位，就再比一次，
            // 如果此时前端值刚好比关键值大，则交换位置，把关键值交换到前端。
            if(array[start]>=key){
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
            //此时第一次循环比较结束，关键值（枢轴）的位置已经确定了。
            // 左边的值都比关键值小，右边的值都比关键值大，
            // 但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //递归，此时分别对枢轴两边进行快排
        //此时low是初始时的开始位置，start则++了好几次，low位至start位构成了左边序列。
        // low作为左边序列的起始位，start其实是枢轴的位置，所以start-1就是左边序列的结束位
        if(start>low) quickSort(array,low,start-1);
        //此时end是枢轴的位置，所以end+1是右边序列的起始位，high是最初的结束为
        // （也就是最后一个数，期间改变的是end，high没变），所以high就是右边序列的结束位
        if(end<high) quickSort(array,end+1,high);
    }

//================================================================================================
    /**
     * 名称：选择排序-直接选择排序
     * 描述：先从头到尾扫一遍，找到最小的数，和第一个交换，
     *      然后从第二个开始找，找到最小的，和第二个位置交换·····
     * 时间复杂度：平均O(n^2)，最坏O(n^2)
     * 稳定性：稳定
     * @param array 待排数组
     */
    public void selectionSort(int[] array){
        int len=array.length;
        int small;//一次比较中最小的下标。
        int temp;
        //初始从第0位开始找，此位放最小的数，之后第1位放第二小的数·····
        for(int i=0;i<len-1;i++){
            small=i;//该此比较中最小的下标

            //把假定最小下标后的下标的值与该值循环比较，每次都将更小的下标赋给small，
            // 一轮下来，small里就是真正的最小下标
            for(int j=i+1;j<len;j++){
                //如果找到比“最小下标”小的值，则将该下标改成最小下标
                if(array[j]<array[small]){
                    small=j;
                }
            }
            //查询一轮下来，判断small是否变更，如果没变就表示目前i位就是最小的，不用换位。否则换位
            if(i!=small){
                //将目前找到的最小元素临时装到temp中
                temp=array[small];

                //此处没有直接将i位于small位交换，
                // 因为直接交换可能会导致相同的数据元素位置发生变化，引起排序不稳定。

                //将第i位至第samll-1位的元素集体向后移一位
                // （这样就刚好把第samll位盖住了，顺序也不会发生改变，也保证了稳定性）
                for(int k=small;k>i;k--){
                    array[k]=array[k-1];
                }
                array[i]=temp;//将目前最小值赋值给第i位
            }
        }
    }

//================================================================================================
    /**
     * 名称：选择排序-堆排序
     * 描述：首先，此序列对应的一维数组可看成是一个完全二叉树
     *      其结构是：如果最顶端为最大值，则“所有的非终端结点的值都大于等于其左右的孩子结点的值”。
     *      将这个完全二叉树经过一遍排序后，其顶端元素为最大值（为最大值则表示最终结果是从小到大排。
     *      如果顶端为最小值，则表示最终数组结果为从大到小排）。
     *      之后将树顶元素和最后一个元素交换位置，交换完后，最后一个元素变成了最小的值。
     *      接着再将除最后一个元素以外的元素看成是完全二叉树，对这个完全二叉树再进行这样的排序···
     *      最终该完全二叉树（也就是一维数组）达到了从小到大的顺序。
     * 时间复杂度：平均O(nlogn)，最坏O(nlogn)
     * 稳定性：不稳定
     * @param array 待排数组
     */
    public void heapSort(int[] array){
        //整个过程分为两步，
        // 第一步：先构成一个根节点为最大元素的堆
        //在完全二叉树中，第i位结点的左孩子结点刚好在（i*2+1）位，右孩子结点在（i*2+2）位。

        //所以此处(array.length-1)/2，
        // 才能找到完全二叉树中的“最末端的非终端结点”（该结点以后的结点都是叶子结点）
        int half = (array.length-1) / 2;

        //堆排序的做法就是“以一个非终端结点和它的左右孩子结点”为一个“三角单位”，
        // 找出该三角单位中最大的数，将该数置于此三角单位的顶结点处。
        // 从最尾部的“三角单位”排起，一直排到根节点和其左右孩子结点组成的“三角单位”，
        // 此时根节点上的最大数就是整个完全二叉树的最大数。
        int len= array.length;

        //此处的i=half就是从“最末端的非终端结点”所组成的“三角单位”开始排起，
        // 每排完一个非终端结点，就i--，找他上一个非终端节点接着排序，直到排到根节点为止。
        for (int i = half; i >= 0; i--) {

            //根据传入的非终端结点，找到“以该非终端结点为顶部结点以及他的左右孩子结点”，
            // 找出三者中的最大数，将其换到该三角单位的顶部结点位。
            heapAdjust(array,len, i);
        }
        //第二步：此时第一轮的排序已经完成，现在有一个根节点为最大元素的堆，
        //我们需要把目前的根节点和末尾元素替换。
        // 然后重新进行一轮排序，找出第二大的元素，放到倒数第二位·····
        //每循环一次，“需要被排序的完全二叉树长度就减一”（因为尾部都是排好序的了）
        for (int i = array.length - 1; i >= 1; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapAdjust(array, i, 0);
        }
    }

    //构建局部最大顶堆，其中array是待排数组。
    // heapSize是目前“需要被排的完全二叉树长度”
    // （因为一轮排完，最大值就放到尾端了，这样需要被排的堆长度就减少了1）。
    // index是任一个“非终端节点位”
    private void heapAdjust(int[] array, int heapSize, int index) {
        int left = index * 2 + 1;//index位的左孩子结点位
        int right = index * 2 + 2;//index位的右孩子结点位

        //最大的结点位（可能是顶位也可能是左右孩子结点位，只要是最大的数，其位置就也是这个）
        int largest = index;

        //左孩子结点不能超过目前堆的长度，且如果左孩子结点大于顶点，就将最大结点位改成左孩子结点位
        if (left < heapSize && array[left] > array[index]) {
            largest = left;
        }
        //右孩子结点不能超过目前堆的长度，
        // 且如果右孩子结点大于“最大结点位上的元素”，就将最大结点位改成右孩子结点位
        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }
        //如果发现原来的顶端结点位已经不是最大结点位了，则将左、右孩子结点中最大的元素与顶端元素换位
        if (index != largest) {
            //将顶端元素暂存
            int temp = array[index];
            //将最大结点位上的元素放到顶端位上
            array[index] = array[largest];
            //将旧顶端元素存到之前的最大顶点位上（因为最大顶点位其实是左右孩子结点中最大的孩子结点位）
            array[largest] = temp;

            //由于左、右孩子结点中的一个已经被替换，
            // 所以有可能破坏了“以旧孩子结点为顶端结点的局部三角排序顺序”，
            // “要以被替换的结点为顶点”重新做一次调整。
            heapAdjust(array, heapSize, largest);
        }
    }

//================================================================================================
    /**
     * 名称：归并排序
     * 描述：假设初始序列含有n个元素，则可看成序列含有n个子序列，每个子序列长度为1，
     *      然后两两合并并排序，得到（n/2）个长度为2（或者最后一个长度可能为1）的有序子序列。
     *      再两两合并并排序·····，如此重复直到得到一个长度为n的有序序列为止。
     * 时间复杂度：平均O(nlogn)，最坏O(nlogn)
     * 稳定性：稳定
     * @param array 待排数组
     * @param left 待排数组的左边起始位
     * @param right 待排数组的右边结束位
     */
    public void mergingSort(int[] array, int left, int right){
        if (left<right){
            //找到传入数组的中间位
            int center = (left + right)/2;
            //将中间位作为“左边边界”递归，这样就能不断二分左边数组
            mergingSort(array, left, center);
            //找到和左边数组对应的右边部分
            mergingSort(array, center + 1, right);
            //根据相关数据可以确定需要排序的范围，进行排序
            merge(array, left, center, right);
        }
    }

    /**
     * 相当于有三个数组：
     * leftPos到leftEnd组成了第一个待排数组，
     * rightPos到rightEnd组成了第二个待排数组。
     * 还有一个空的数组用来临时存储结果。
     *
     * 每次将两个待排数组的最靠前项相比较，
     * 将其中最小的一项放入空数组中，
     * 然后该最小项所在数组的靠前下标+1
     *
     * 即有a[],b[]两个数组比较，
     * 先比较a[0],b[0]，发现a[0]小，就将a[0]放入result[],再比较a[1]和b[0]······
     *
     * 其中两个待排数组自身肯定是有序的（因为他们也是经过现有步骤排出来的）
     *
     * 当其中某个待排数组排完后，
     * 就表示“另一个待排数组的剩余项肯定大于之前所有的排序项”，又因为剩余项是有序的，
     *
     * 所以可以将剩余项全部按序装入临时结果数组。
     * 之后用结果数组覆盖掉原数组
     *
     * @param array 待排数组
     * @param leftPos 待排数组的左边部分的起始位
     * @param leftEnd 待排数组左边部分的结束位
     * @param rightEnd 待排数组右边部分的结束位
     */
    private void merge(int[] array, int leftPos, int leftEnd, int rightEnd) {
        int[] tmpArr = new int[rightEnd+1];//临时的结果数组，将排序后的结果存放其中
        int rightPos = leftEnd + 1;//位于右边的待排数组开始位
        int tmpPos = leftPos; //临时数组的存储位，每存一个，就后移一位
        int tmp = leftPos;//排序的起始位置

        // 从两个数组中取出最小的放入临时数组
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if ((array[leftPos] <= array[rightPos])){
                tmpArr[tmpPos++] = array[leftPos++];
            }else {
                tmpArr[tmpPos++] = array[rightPos++];
            }
        }

        //此时肯定有一个待排数组已经排完了，现在查找那个数组排完了，
        // 并将另一个数组的剩余部分装入临时数组
        while (rightPos <= rightEnd) {
            tmpArr[tmpPos++] = array[rightPos++];
        }
        while (leftPos <= leftEnd) {
            tmpArr[tmpPos++] = array[leftPos++];
        }

        // 将临时数组中的内容复制回原数组
        for (int i = tmp; i <= rightEnd; i++) {
            array[i] = tmpArr[i];
        }
    }

//================================================================================================
    /**
     * 名称：基数排序
     * 描述：在描述基数排序前先描述一下“桶排序”：
     *      桶排序：
     *      假设待排数组{A1，A1，A3·····}中所有的数都小于“M”，
     *      则建立一个长度为M的数组count[M]，初始化为全0。
     *      当读取A1时，将count[A1]增1（初始为0，现在为1），当读取A2时，将count[A2]增1····
     *      之后count[M]中的每一个非0项的顺序就是排序结果。
     *      基数排序：
     *      对于数组中的所有项的“每一位数”都进行桶排序。
     *      比如先对所有项的“个位”进行桶排序，根据个位的桶排序的结果，对各个项进行一次排序。
     *      之后再对十位进行桶排序··········
     * 时间复杂度（d代表长度，n代表关键字个数，r代表关键字的基数）：平均O(d(n+rd))，最坏O(d(n+rd))
     * @param array 待排数组
     * @param len_max 待排数组项的最高位位数，如待排数组={2,23,233,2333}，则len_max为4（2333的位数）
     * 稳定性：稳定
     */
    public void radixSort(int[] array,int len_max){
        /**
         * 一般的桶排序的count[]只是一维数组，
         * 里面的每项（0-9）的具体值代表了该数出现的次数，
         * 如count[2]=3，代表2这个“项”，出现了3次。
         *
         * 但现在是“从个位开始”，每一位都要做桶排序。
         * 如果还是使用count[]，
         * 那么count[2]=3只能代表“在所有项的第n位桶排序中”2这个数“作为第n位数”出现了3次。
         *
         * 显然，正常的流程是：
         * 先查找“个位”的count[0]=n，将这些“个位为0”的数从第0位开始放入数组。
         * 再看“个位”的count[1]=m，将这些“个位为1”的数紧挨着刚刚插入的数插进来。·····
         * “个位”的第一轮排序完后，原数组相当于“依据个位大小，进行了一次排序”，
         * 接下来就要“依据十位大小再进行一次排序了”····。
         *
         * 综上流程能够发现，第n位中count[2]=3，这个2代表了“3个n位为2的数”，
         * 我们要排序就必须知道“这3个数具体是什么”，然后把这些数按序放入原数组。
         * 所以引入二维数组count[][]，
         * 第一维的下标代表了该位数“具体是几”，所以范围是0-9。
         * 第二维的下标代表了该位数相同的值“第几次出现”，
         * （如个位桶排序时，count[2][34]就代表了第34个“个位为2的数”。）
         * 第二维中存储的是具体的某个数
         */
        int[][] count = new int[10][array.length];

        //该数组frequency[n]=m，用来计算“某位的桶排序”中“n这个数第m次出现”。
        // 所以n的范围只能是0-9，而m最多可能是原数组的长度（当该数组某一位的值都是同一个数时）
        int[] frequency = new int[10];

        int now_digit = 1;//当前排序的是各项的第几位数（从第一位（个位）开始排）
        int n = 1;//用来计算当前位的具体值

        //从个位开始排，然后再排十位·····
        while (now_digit<=len_max){
            //根据原数组中各项的“now_digit位”，进行桶排序。
            for (int i=0;i<array.length;i++){
                //找到具体某位的值。如n=1时，找到的就是个位的值。n=10时，找到的就是十位的值
                int digit = ((array[i] / n) % 10);
                count[digit][frequency[digit]]=array[i];
                frequency[digit]++;
            }

            /**
             * 现在所有的项已经根据桶排序规则存入count[][]中，现在需要按序再存回原数组。思路如下：
             * count[][]中第一个下标意味着“当前位”的具体值，为0-9.
             * 所以应该将count[0][n]中的各个数排在前面，count[1][m]中的各项跟在后面·····
             * count[0][]中存了多个“当前位为0的数”，
             * 而count[][]的第二个下标表示“被存储的数”是“第几个下标为0的数”。
             * 如:当前位为“个位”排序时，count[0][1]=21表示21是第一个“个位为0的数”，
             *    count[0][6]=341表示341是第6个“个位为0的数”
             */
            //把数据存在原数组的什么位置（起始的存储位置自然是0，然后每存一个数后移一位）
            int k = 0;
            //从count[i=0][]开始找，然后找count[i++][]····
            for(int i = 0; i < 10; i++) {
                //frequency[i]代表了“i这个数第几次出现”，所以为0就表示没出现过，也就不用排了
                if(frequency[i] != 0){
                    //从第0次出现开始找，每次都装入原数组
                    for(int j = 0; j < frequency[i]; j++) {
                        //j代表了“位值为i”的数是第几个，count[i][j]代表了该数
                        array[k] = count[i][j];
                        k++;
                    }
                }
                //“当前位数”为i的数已经存完，需要初始化，否则下一“位数为i”的数存时会出错。
                frequency[i] = 0;
            }
            //每循一次，用来计算当前位的具体值的n做+10处理
            n *= 10;
            //每循一次，当前位数+1
            now_digit++;
        }
    }

    //一个简单的桶排序
    private void bucketSort(){
        int[] array_demo = {2,5,7,3,1,6,8,4,2,1,3,7,9,4,2,5,0};
        int[] count = new int[10];
        int m=0;

        for (int i:array_demo){
            count[i]++;
        }

        for (int i=0;i<10;i++){
            if (count[i]!=0){
                for (int k=0;k<count[i];k++){
                    array_demo[m] = i;
                    m++;
                }
            }
        }
    }


    public static void main(String[] args) {
        SortCompare sorting_util = new SortCompare ();

        //直接插入排序
        int[] param_straightInsertionSort= {6,2,8,5,324,23423,56,2,87,3,42,436};
        sorting_util.straightInsertionSort(param_straightInsertionSort);
        printResult("插入排序-直接插入排序：",param_straightInsertionSort);

        //希尔排序
        int[] param_shellSort= {6,2,8,5,324,23423,56,2,87,3,42,436};
        int incrementNum = param_shellSort.length/2;//增量
        sorting_util.shellSort(param_shellSort,incrementNum);
        printResult("插入排序-希尔排序：",param_shellSort);

        //冒泡排序
        int[] param_bubbleSort= {6,2,8,5,324,23423,56,2,87,3,42,436};
        sorting_util.bubbleSort(param_bubbleSort);
        printResult("交换排序-冒泡排序：",param_bubbleSort);

        //快速排序
        int[] param_quickSort= {6,2,8,5,324,23423,56,2,87,3,42,436};
        sorting_util.quickSort(param_quickSort,0,param_quickSort.length-1);
        printResult("交换排序-快速排序：",param_quickSort);

        //直接选择排序
        int[] param_selectionSort= {6,2,8,5,324,23423,56,2,87,3,42,436};
        sorting_util.selectionSort(param_selectionSort);
        printResult("选择排序-直接选择排序：",param_selectionSort);

        //堆排序
        int[] param_heapSort= {6,2,8,5,324,23423,56,2,87,3,42,436};
        sorting_util.heapSort(param_heapSort);
        printResult("选择排序-堆排序：",param_heapSort);

        //归并排序
        int[] param_mergingSort= {6,2,8,5,324,23423,56,2,87,3,42,436};
        sorting_util.mergingSort(param_mergingSort, 0, param_mergingSort.length-1);
        printResult("归并排序：",param_mergingSort);

        //基数排序
        int[] param_radixSort= {6,2,8,5,324,23423,56,2,87,3,42,436};
        sorting_util.radixSort(param_radixSort,5);
        printResult("基数排序：",param_radixSort);
    }

    /**
     * 将排序结果展示出来
     * @param sort_type 用来描述排序方法
     * @param array_result 排序结果数组
     */
    public static void printResult(String sort_type,int[] array_result){
        System.out.print(sort_type);
        for (int i:array_result){
            System.out.print(i+",");
        }
        System.out.println();
    }
}

