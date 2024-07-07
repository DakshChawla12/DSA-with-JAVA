public class custom_DynamicQueue extends custom_CircularQueue {

    public custom_DynamicQueue(){
        super();
    }
    public custom_DynamicQueue(int size){
        super(size);
    }

    @Override
    public boolean insert(int item){
        if(this.isFull()){
            int[]newData = new int[data.length * 2];
            for(int i = 0; i < data.length; i++){
                newData[i] = data[(front+i)%data.length];
            }
            front = 0;
            end = data.length;
            data = newData;
        }
        return super.insert(item);
    }

}
