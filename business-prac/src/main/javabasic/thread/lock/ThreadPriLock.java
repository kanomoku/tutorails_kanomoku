package thread.lock;

public class ThreadPriLock extends Thread{
        private Service service;

        public ThreadPriLock(Service service) {
            this.service = service;
        }

        @Override
        public void run() {
            service.method_pri_lock();
        }
}