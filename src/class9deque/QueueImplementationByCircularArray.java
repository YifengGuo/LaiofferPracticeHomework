package class9deque;

/**
 * 
 * @author @Yifeng
 *  make array look like a circle
 *  assume the array is bounded
 *  
 *  step1: if use primitive array
 *       1 2 3 4 5 6 7 8 9 10
 *       head points to first node in queue   poll() head++
 *       tail points next available insertion position in queue offer() tail++
 *       
 *       so if tail reaches at array.length - 1, and we keep offer()?
 *       
 *  step2: import concept of circular array, making the array look like a circle
 *         head = head + 1 == array.length ? 0 : head + 1  or head = (head + 1) % array.length 
 *         to keep head position from out of bound  
 *       
 */
public class QueueImplementationByCircularArray {

}
