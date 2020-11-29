package de.stl.saar.internetentw1.view;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

import de.stl.saar.internetentw1.model.Language;
import de.stl.saar.internetentw1.utils.JsfUtils;
import de.stl.saar.internetentw1.utils.StringUtils;



/**
 * This bean managed the internationalization. It contains the available languages and the listeners that are fired
 * when the language is changed. 
 * @author Christopher Olbertz
 *
 */
@Named
@SessionScoped
public class I18nBean implements Serializable {

	/**
	 * Field serialVersionUID.
	 * (value is 1)
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The code of the current locale.
	 */
	private String localeCode;

	/**
	 * Contains the available languages.
	 */
	private List<Language> languages;

	/**
	 * Initializes the available languages.
	 */
	@PostConstruct
	public void initialize() {
		languages = new ArrayList<Language>(); 
		languages.add(new Language(Locale.GERMAN, "Deutsch"));
		languages.add(new Language(Locale.ENGLISH, "English"));
		localeCode = Locale.GERMAN.getLanguage();
	}

	/**
	 * Is fired if the user wants to change the language. Looks for the selected language in the list with the 
	 * available languages and sets the new locale.
	 * @param valueChangeEvent The event that was fired. 
	 */
	public void onLocaleCodeChange(ValueChangeEvent valueChangeEvent) {
		final String newLocale = valueChangeEvent.getNewValue().toString();

		for (final Language language: languages) {
			if (StringUtils.areStringsEqual(language.getLanguageDescription(), newLocale)) {
				JsfUtils.setLocale(language.getLocale());
			}
		}
	}

	public String getLocaleCode() {
		return localeCode;
	}

	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	/**
	 * Returns the language selected  by the user. If no language is selected the first
	 * language is returned.
	 * @return The selected language or the first language. 
	 */
	public Language getSelectedLanguage() {
		if (StringUtils.isEmpty(localeCode)) {
			for (final Language language: languages) {
				if (StringUtils.areStringsEqual(language.getLanguageCode(), localeCode)) {
					return language;
				}
			}
		}
		
		return languages.get(0);
	}
}