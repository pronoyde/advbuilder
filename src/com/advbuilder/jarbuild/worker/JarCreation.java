package com.advbuilder.jarbuild.worker;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class JarCreation {

	public int main(String buildPath, String jarLocation, String manifestFileLocation, String classFilesLocation, String outputFileName) {
		// TODO Auto-generated method stub
		try {
			/*
			 * buildPath="/home/pronoyde/Documents/SampleJavaJson/bin/";
			 * jarLocation="/usr/jdk/jdk1.8.0_212/bin/jar"; manifestFileLocation=
			 * "/home/pronoyde/Documents/SampleJavaJson/bin/Manifest.MF";
			 * classFilesLocation="/home/pronoyde/Documents/SampleJavaJson/bin/";
			 * outputFileName="testOutput.jar";
			 */
			String cmd=jarLocation+" cvfm "+outputFileName+" "+manifestFileLocation+" -C "+classFilesLocation+" .";
			System.out.println(cmd);
			File workingDirectory = new File(buildPath);
			execute(cmd, workingDirectory);
			return 0;
		}
		catch(Exception e){
			return 1;
		}
	}
	private void execute(String cmd,File workingDirectory) {
		try {
			Process process = Runtime.getRuntime().exec(cmd, null, workingDirectory);;
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader stdErr = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			String si=null;
			String se=null;
			while((si=stdIn.readLine())!=null)
			{
				System.out.println(si);
			}
			while((se=stdErr.readLine())!=null)
			{
				System.err.println(se);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
