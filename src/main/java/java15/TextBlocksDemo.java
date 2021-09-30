package java15;

// JEP 378: https://openjdk.java.net/jeps/378
// previewed in 13, 14

public class TextBlocksDemo {

	public static void main(String[] args) {
		//Opening and Closing Delimiters: """
		//Line Terminator suppressed by \
		String htmlOld = "<html>\n" +
			"    <body>\n" +
			"        <p>Hello, world</p>\n" +
			"    </body>\n" +
			"</html>\n";

		String htmlNew = """
              <html>
                  <body>
                      <p>Hello, world</p>
                  </body>
              </html>
              """;
		String queryOld = "SELECT \"EMP_ID\", \"LAST_NAME\" FROM \"EMPLOYEE_TB\"\n" +
			"WHERE \"CITY\" = 'INDIANAPOLIS'\n" +
			"ORDER BY \"EMP_ID\", \"LAST_NAME\";\n";

		String queryNew = """
               SELECT "EMP_ID", "LAST_NAME" FROM "EMPLOYEE_TB"
               WHERE "CITY" = 'INDIANAPOLIS'
               ORDER BY "EMP_ID", "LAST_NAME";
               """;
		System.out.println(htmlOld);
		System.out.println(htmlNew);
		System.out.println(queryOld);
		System.out.println(queryNew);
	}

}
