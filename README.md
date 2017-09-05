# jtopia-configurator

| jtopia  | jtopia-configurator  |
|---------|----------------------|
| [![Release](https://jitpack.io/v/moritzfl/jtopia.svg)](https://jitpack.io/#moritzfl/jtopia)  |  [![Release](https://jitpack.io/v/moritzfl/jtopia-configurator.svg)](https://jitpack.io/#moritzfl/jtopia-configurator) |

Language resources for jtopia in Danish, Dutch, English, French, German, Portuguese, Spanish and Swedish. Details on jtopia can be found [here](https://github.com/moritzfl/jtopia)

How to Use
==========

with jtopia-configurator (separate library) you can rely on integrated resources and a helper class (Configurator) to provide you with an easy configuration:

        Configurator.setConfigurationToModel(Configurator.OPENNLP_ENGLISH_POS_MAXENT);
        Configurator.setConfigurationToStopWords(Configurator.STOPWORD_ENGLISH_LONG);

        Configuration.setSingleStrength(3);
        Configuration.setNoLimitStrength(2);

        String text = "You should use text where keyword-extraction makes sense";

        TermsExtractor termExtractor = new TermsExtractor();
        TermDocument topiaDoc = termExtractor.extractTerms(text);

        logger.info("Extracted terms : " + topiaDoc.getExtractedTerms());
        logger.info("Final Filtered Terms : " + topiaDoc.getFinalFilteredTerms());

jtopia maven artifacts
======================
Maven artifacts are provided through jitpack.io. You therefore need to add the according repository to your project.

**Repository:**

	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
    
**Artifact:**

*Note: jtopia-configurator already depends on jtopia, so in case you choose to use jtopia-configurator, you do not  need jtopia in your list of dependencies.*

	<dependency>
	    <groupId>com.github.moritzfl</groupId>
	    <artifactId>jtopia-configurator</artifactId>
	    <version>0.2</version>
	</dependency>
  
