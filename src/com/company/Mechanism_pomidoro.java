package com.company;


public class Mechanism_pomidoro extends Thread {

    static long time_start;
    static boolean flag_pause = true;
    static long work_timer = 10000;
    static long rest_timer = 1000;
    static boolean flag_work = true;
    static long time_that_passed; //прошедшее время

    @Override
    public void run(){ //предлагаю его включить до инициализации
        // таймера и профиля или перенести сист время
        time_start = System.currentTimeMillis();
        while (true)
        {
            //тут код по проверке окончания времени



            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static long get_remaining_time(){ //как параметр основного таймера

        return (1800000 - System.currentTimeMillis() % 1800000 ) / 1000;
    }

    public boolean stop_mechanism(long work_timer, long rest_timer){
        Mechanism_pomidoro.work_timer = work_timer;
        Mechanism_pomidoro.rest_timer = rest_timer;
        time_start = System.currentTimeMillis();

        pause_mechanism();


        return true;
    }
    public int start_mechanism(){

        return 0;
    }
    public int pause_mechanism(){

        if(!flag_pause) {
            time_that_passed = time_start - System.currentTimeMillis();
            flag_pause = true;
        }

        return 0;
    }
    public boolean plusTime_mechanism(long time){
        if (!flag_pause)
        {
            time_start += time;
        }
        return true;
    }
    public String state_mechanism(){
        if (flag_pause){
            return "pause";
        } //и так далее

        return null;
    }






}
