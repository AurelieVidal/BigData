import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;
public class VenteReducer extends Reducer<Text, FloatWritable, Text, FloatWritable>
{
    //2
    private FloatWritable result = new FloatWritable();
    public void reduce(Text key, Iterable<FloatWritable> values, Context
            context) throws IOException, InterruptedException {
        float Sum=0;
        for(FloatWritable val: values) {
            Sum = Sum + val.get();
        }
        result.set(Sum);
        context.write(key, result);
    }
}
