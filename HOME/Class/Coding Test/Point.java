

     public class Point{
   
        private int x;
        private int y;
    
        //fill in missing code
        private int xMax = 10    ;
        private int xMin = 0    ;
    
        private int yMax = 15   ;
        private int yMin = 5   ;
    
        //constructor
        public Point(int x, int y){
            this.setX(x);
            this.setY(y);
            System.out.println("Constructor call"+x +y);
        }
    
        private void setX(int x){
            if (this.x > xMax){
                System.out.println("xMax cannot exceed "+xMax);
    
            }else if(this.x < xMin){
                System.out.println("xMin cannot be less than "+xMin);
    
            }else{
                this.x=x;
            }
        }
    
        public void setY(int y){
            if (y> yMax){
                System.out.println("yMax cannot exceed "+yMax);
    
            }else if(y < yMin){
                System.out.println("yMin cannot be less than " + yMin);
    
            }else{
                this.y=y;
            }
        }
    
        public int getX(){
            return this.x;
        }
        
        public int getY(){
            return this.y;
        }
        
        @Override
        public String toString(){
            //fill in the missing code (Hint: take a look at the example output)
            return "(" + this.x + ", " + this.y + ")"; 
        }
    
       
        
    }
    
    
    
