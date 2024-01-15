/**
 * semaphore
 * int value;
 * struct process *next;
 */

/**
 * P wait(){
 *     value --;
 *     if(value < 0)
 *       block(next);
 * }
 * V signal(){
 *     value ++;
 *     if(value <= 0)
 *       wakeup(next);
 * }
 */

/**
 * Buffer : data
 * provider :
 * consumer :
 * flag :
 * wait(flag);
 * provider --> Buffer
 * signal(flag);
 *
 */

/*
    semaphore
 */