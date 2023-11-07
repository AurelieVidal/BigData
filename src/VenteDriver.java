import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
public class VenteDriver {
    public static void main(String[] args) throws Exception {
        Configuration Conf = new Configuration();
        Job Traitement = Job.getInstance(Conf, "Total Ventes par Pays");
        Traitement.setJarByClass(VenteDriver.class);
        Traitement.setMapperClass(VenteMapper.class);
        Traitement.setReducerClass(VenteReducer.class);
        Traitement.setOutputKeyClass(Text.class);
        Traitement.setOutputValueClass(FloatWritable.class);
        TextInputFormat.addInputPath(Traitement, new
                Path("storage/purchases.txt"));

        FileOutputFormat.setOutputPath(Traitement, new
                Path("storage/Sales/Resultats_Traitement_4"));

        System.exit(Traitement.waitForCompletion(true) ? 0 : 1);
    }
}

