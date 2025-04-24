class Counter {

    private Integer i = 1;

    Counter (Integer i){
        this.i=i;
    }
   
    public Integer get_i(){
        return this.i;
    }

    public String toString() {
        return Integer.toString(i);
    }

}
    