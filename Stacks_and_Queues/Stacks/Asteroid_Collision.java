import java.util.Stack;

public class Asteroid_Collision {

public int[] asteroidCollision(int[] asteroids) {
    int n = asteroids.length;
    Stack<Integer> st = new Stack<>();


    for (int i = 0; i < n; i++) {
        // Check if the asteroid is positive or the stack is empty
        if (asteroids[i] > 0 || st.isEmpty()) {
            st.push(asteroids[i]);
        } else {
            // Handle collision with negative asteroids
            while (!st.isEmpty()) {
                int top = st.peek();

                if (top < 0) {
                    st.push(asteroids[i]);
                    break;
                }

                int pos = Math.abs(asteroids[i]);

                // If the positive asteroid size equals the top negative asteroid size, both asteroids annihilate each other
                if (pos == top) {
                    st.pop();
                    break;
                } else if (pos < top) {
                    // If the positive asteroid size is smaller than the top negative asteroid size, no collision occurs
                    break;
                } else {
                    // If the positive asteroid size is larger, the negative asteroid is destroyed
                    st.pop();

                    // If the stack becomes empty, push the current positive asteroid
                    if (st.isEmpty()) {
                        st.push(asteroids[i]);
                        break;
                    }
                }
            }
        }
    }


    int[] ans = new int[st.size()];
    for (int i = st.size() - 1; i >= 0; i--) {
        ans[i] = st.pop();
    }

    return ans;
}

    
}