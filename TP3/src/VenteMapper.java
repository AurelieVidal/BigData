import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class VenteMapper extends Mapper<LongWritable, Text, Text, FloatWritable>
{

    private static FloatWritable one;
    private Text City = new Text();
    public void map(LongWritable Key, Text value, Mapper.Context context)
            throws IOException, InterruptedException{
        String InputLine = value.toString();
        String[] Splited_InputLine = InputLine.split("\t");
        City.set(Splited_InputLine[2]);
        String s = Splited_InputLine[4];
        float ss =Float.parseFloat(s);
        one = new FloatWritable(ss);
        context.write(City, one);
    }
}
