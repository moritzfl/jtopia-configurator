# jtopia-configurator

| jtopia  | jtopia-configurator  |
|---------|----------------------|
| [![Release](https://jitpack.io/v/moritzfl/jtopia.svg)](https://jitpack.io/#moritzfl/jtopia)  |  [![Release](https://jitpack.io/v/moritzfl/jtopia-configurator.svg)](https://jitpack.io/#moritzfl/jtopia-configurator) |

Language resources for jtopia in Danish, Dutch, English, French, German, Portuguese, Spanish and Swedish. Details on jtopia can be found [here](https://github.com/moritzfl/jtopia)

**GPL3 vs Apache License 2.0? (or jtopia-configurator vs jtopia)**

Because the jtopia-configurator includes language resources from the [Stanford POS Tagger](https://nlp.stanford.edu/software/tagger.shtml) it is infected by the GPL and may only be used under the terms of this license. If this is an issue for you, just use jtopia which is distributed under Apache License 2.0 and bring your own language resources (not as convenient but easy enough to do - for example with [OpenNLP models](http://opennlp.sourceforge.net/models-1.5/)).

How to Use
==========

with jtopia-configurator you can rely on integrated resources and a helper class (Configurator) to provide you with an easy configuration:

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
	    <version>0.3</version>
	</dependency>
  
