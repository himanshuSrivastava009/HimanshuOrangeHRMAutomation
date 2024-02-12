package multi.threading.project.example;
/*
 * {
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": "ec2:Describe*",
            "Resource": "*"
        },
        {
            "Effect": "Allow",
            "Action": "elasticloadbalancing:Describe*",
            "Resource": "*"
        },
        {
            "Effect": "Allow",
            "Action": [
                "cloudwatch:ListMetrics",
                "cloudwatch:GetMetricStatistics",
                "cloudwatch:Describe*"
            ],
            "Resource": "*"
        },
        {
            "Effect": "Allow",
            "Action": "autoscaling:Describe*",
            "Resource": "*"
        }
    ]
}
 */

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AWSJson {

	private String version;
	private ArrayList<Statements> statements;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public ArrayList<Statements> getAl() {
		return statements;
	}

	public void setAl(ArrayList<Statements> statements) {
		this.statements = statements;
	}

	public static void main(String[] args) throws JsonProcessingException {

		AWSJson aws = new AWSJson();
		aws.statements = new ArrayList<Statements>();
		aws.statements.add(new Statements("Allow", "AutoScaling", "*"));
		aws.statements.add(new Statements("listmatrics", "getMetrices", "*Describe"));
		aws.statements.add(new Statements("Allow", "ec2:Describe*", "Test*"));
		aws.setVersion("1.2.3.4");

		ObjectMapper mapper = new ObjectMapper();
		String jsonvalue = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(aws);
		System.out.println(jsonvalue);
		
		AWSJson value = mapper.readValue(jsonvalue, AWSJson.class);
		System.out.println(value.getVersion());

	}
}
