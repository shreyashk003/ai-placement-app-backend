package mmec.ai.placement.ai_placement_app.Controller;

import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PlacementController {
    String result="";
    @PostMapping("/run-python")
    public String runPythonScript(@RequestBody String[] args) {
        System.out.println(args);

         for(String x:args)
             System.out.print(x+ "  ");

        String [] myargs=args;
        String sslc=(myargs[0]);
        String puc=(myargs[1]);
        String be1=(myargs[2]);
        String be2=(myargs[3]);
        String be3=(myargs[4]);

        String apti=(myargs[5]);
        String cskill=(myargs[6]);
        String dsa=(myargs[7]);
        String db=(myargs[8]);
        String se=(myargs[9]);
        String os=(myargs[10]);
        String cn=(myargs[11]);
        String oops=(myargs[12]);
        String alg =(myargs[13]);

        String hack=(myargs[14]);
        String coda=(myargs[15]);
        String intern=(myargs[16]);
        String techevents=(myargs[17]);
        String proj=(myargs[18]);

        try {
            // Adjust the path to your Python script
            String pythonScriptPath = "D:\\ai-placement-app\\src\\main\\resources\\PythonCode\\randomForestPredictorStored1.py";

            // Construct the command to run the Python script
            ProcessBuilder processBuilder = new ProcessBuilder("python", pythonScriptPath,
                    sslc,puc,be1,be2,be3,apti,cskill,dsa,db,se,os,cn,oops,
                    alg,hack,coda,intern,techevents,proj
            );

            System.out.println("I am done..");
            processBuilder.redirectErrorStream(true);

            // Start the

            Process process = processBuilder.start();

            // Read the output from the process
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    result += line + "\n";
                }
            }

            // Wait for the process to complete
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error running Python script: " + e.getMessage();
        }
        System.out.println(result);
        return result;
    }


}

