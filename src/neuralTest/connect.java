package neuralTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.Object;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.openimaj.audio.AudioFormat;
import org.openimaj.audio.AudioPlayer;
import org.openimaj.audio.JavaSoundAudioGrabber;
import org.openimaj.audio.SampleChunk;
import org.openimaj.audio.analysis.FourierTransform;
import org.openimaj.audio.features.MFCC;
import org.openimaj.audio.processor.FixedSizeSampleAudioProcessor;
import org.openimaj.video.xuggle.XuggleAudio;
import org.openimaj.vis.audio.AudioWaveform;

import edu.cmu.sphinx.frontend.Data;
import edu.cmu.sphinx.frontend.DataProcessor;
import edu.cmu.sphinx.frontend.FrontEnd;
import edu.cmu.sphinx.frontend.frequencywarp.MelFrequencyFilterBank;
import edu.cmu.sphinx.frontend.transform.DiscreteCosineTransform2;
import edu.cmu.sphinx.frontend.transform.DiscreteFourierTransform;
import edu.cmu.sphinx.frontend.util.AudioFileDataSource;

public class connect {

	public static void main(String[] args) throws MalformedURLException {
		//		XuggleAudio xa = new XuggleAudio( new File( "myAudioFile.mp3" ) );
		//		AudioPlayer.createAudioPlayer( xa ).run();
		//		
		//		final AudioWaveform vis = new AudioWaveform( 400, 400 );
		//		vis.showWindow( "Waveform" );
		//
		//		final XuggleAudio xa = new XuggleAudio( 
		//		    new URL( "http://www.audiocheck.net/download.php?" +
		//		        "filename=Audio/audiocheck.net_sweep20-20klin.wav" ) );
		//
		//		SampleChunk sc = null;
		//		while( (sc = xa.nextSampleChunk()) != null )
		//		    vis.setData( sc.getSampleBuffer() );
		//		
		//		
		//		MFCC mfcc = new MFCC( xa );
		//		
		//		while( (sc = mfcc.nextSampleChunk()) != null )
		//		{
		//			double[][] mfccs = mfcc.getLastCalculatedFeature();
		//			vis.setData( mfccs[0] );
		//		}
		//		
		//		JavaSoundAudioGrabber jsag = new JavaSoundAudioGrabber( new AudioFormat( 16, 44.1, 1 ) );
		//		FixedSizeSampleAudioProcessor fssap = new FixedSizeSampleAudioProcessor( jsag, 441*3, 441 );

		AudioFileDataSource audioDataSource = new AudioFileDataSource(3200, null);

		audioDataSource.setAudioFile(new URL("file:///path/to/my.wav", "source");

		final ArrayList<DataProcessor> pipeline = new ArrayList<DataProcessor>();

		pipeline.add(audioSource);
		pipeline.add(new DiscreteFourierTransform());
		pipeline.add(new MelFrequencyFilterBank(minFreq, maxFreq, numFilters));
		pipeline.add(new DiscreteCosineTransform2(numFilters, 12));
		FrontEnd f = new FrontEnd(pipeline);

		Data mfccs;
		do {
			mfccs = f.getData();
		} 
		while(mfccs != null) 



	}


	public static int MLCal (double[] input) {	

		//parameters
		double [][] fc1Weight = {
				{	-0.233562514
					,	0.073163345
					,	0.162523463
					,	-0.475291908
					,	0.153847501
					,	0.250875354
					,	-0.159885272
					,	0.325949907
					,	0.007859653
					,	0.097039938
					,	-0.161264479
					,	-0.205180123},

				{	-0.30799529
						,	0.031105876
						,	0.127346873
						,	-0.564684391
						,	0.077051081
						,	0.169108436
						,	-0.327682018
						,	0.358338505
						,	-0.019924065
						,	0.106168672
						,	-0.206807643
						,	-0.206969202},

				{	-0.329386055
							,	0.097163714
							,	0.127564043
							,	-0.512097239
							,	0.154471964
							,	0.191515937
							,	-0.258915633
							,	0.2857714
							,	-0.052398041
							,	0.153321788
							,	-0.155209497
							,	-0.183188558}


		};
		double[][] fc2Weight = {
				{0.368401468
					,0.411503017
					,0.390290767},
				{-0.358836472
						,	-0.406123072
						,	-0.384561062}
		};

		double [] fc1Bias = {-0.013109485
				,-0.006122951
				,0.001943798};
		double [] fc2Bias = {0.196922183,-0.196922451};
		//declare first layer output
		double[] fc1Output = {0,0,0};
		//first layer calculation
		for(int j = 0; j < 3; j ++) {
			for(int i = 0 ; i <input.length;i++) {
				fc1Output[j] = fc1Output[j] + fc1Weight[j][i]*input[i];
			}	
			fc1Output[j] = fc1Output[j] +fc1Bias[j] ;
		}
		//declare second layer output
		double fc2Output [] = {0,0};
		//second layer calculation
		for(int j = 0; j < 2; j ++) {
			for(int i = 0 ; i <input.length;i++) {
				fc2Output[j] = fc2Output[j] + fc2Weight[j][i]*input[i];
			}	
			fc2Output[j] = fc2Output[j] +fc2Bias[j] ;
		}

		//throw in second layer output and get softmax output
		double [] output  = softmax(fc2Output);

		//if the first one has larger probability return 0, else return 1
		if(output[0]>output[1]) {
			return 0;
		}
		else {
			return 1;
		}
	}



	public static double[] softmax (double [] input) {
		//declare output
		double [] output = new double [input.length];
		double sum = 0;
		//find the sum of the exponential of all numbers in input
		for(int i = 0 ;  i < input.length; i++) {
			sum = sum + Math.exp(input[i]);
		}
		//divide the input number by the sum
		for(int i = 0 ; i< output.length; i++) {
			output[i] = input[i]/sum; 
		}
		//return output
		return output;
	}


}
