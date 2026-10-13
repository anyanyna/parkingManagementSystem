export function createLocaleLang(locales) {
    const messages = {};
    for (const path in locales) {
        const matched = path.split('/')
        if (matched) {
            const locale = matched[2];
            messages[locale] = messages[locale] || { translation: {} };
            Object.assign(messages[locale].translation, locales[path].default);
        }
    }
    return messages;
}