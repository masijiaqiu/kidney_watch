import nltk
from nltk.stem import WordNetLemmatizer
from itertools import chain
from nltk.corpus import wordnet


text = """NEW CONSULT VISIT     DATE:Nov 25th, 2016                                           NEPHROLOGIST:Dr. Rosenstein PT AGE: 51  BLOODWORK DATE: Creatinine:     407          eGFR:  14             ACR:  na            Date of ACR Test:  Oct 14th, 2016               PATIENT CONCERNS:Saw Dr. Ganghi in Sept 2016.  INTERCURRENT ISSUES: VITAL SIGNS: (See flow sheet under vital signs tick box)   INTERCURRENT ISSUES: Family history: Dialysis/transplant:kidney transplant 8 years ago  SOCIAL ISSUES:married  ALCOHOL USE:none SMOKING HISTORY:none NSAID USE:none              Home BP Range:145/85 Weight:102.6kg"""

def isSmoking(text):
	lemmatizer = WordNetLemmatizer()

	sentences = sent_tokenize(text)
	for sentence in sentences:
		tokens = nltk.word_tokenize(sentence)
		
		index = 0
		i = 0
		for word in tokens:
			lemma = lemmatizer.lemmatize(word, pos='v')
			if (lemma == "smoke"):
				index = i
				break
			i += 1



	

	

	print text.concordance(u'egfr')   # extract keyword



for ss in wordnet.synsets('small'):
	print(ss.name(), ss.lemma_names())  # synonym

print lemmatizer.lemmatize(u'smoking', pos='v')  # find lemma