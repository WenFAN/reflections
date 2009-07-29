package org.reflections.util;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableSet;
import org.reflections.Configuration;
import org.reflections.adapters.JavassistAdapter;
import org.reflections.adapters.MetadataAdapter;
import org.reflections.scanners.Scanner;

import java.net.URL;
import java.util.Collection;
import java.util.Set;

/**
 * an abstract implementation of {@link org.reflections.Configuration}
 * <p>uses reasonalbe defaults, such as {@link #useForkjoin}=true, {@link #filter}=accept all
 */
@SuppressWarnings({"RawUseOfParameterizedType"})
public class AbstractConfiguration implements Configuration {
    private Set<Scanner> scanners;
    private Set<URL> urls;
    private MetadataAdapter metadataAdapter = new JavassistAdapter();
    private Predicate<String> filter = Predicates.alwaysTrue();
    private boolean useForkjoin = true;

    public Set<Scanner> getScanners() {
		return scanners;
	}

    public void setScanners(final Scanner... scanners) {
        this.scanners = ImmutableSet.of(scanners);
    }

    public Set<URL> getUrls() {
        return urls;
    }

    public void setUrls(final Collection<URL> urls) {
		this.urls = ImmutableSet.copyOf(urls);
	}

    public MetadataAdapter getMetadataAdapter() {
        return metadataAdapter;
    }

    public void setMetadataAdapter(final MetadataAdapter metadataAdapter) {
        this.metadataAdapter = metadataAdapter;
    }

    public Predicate<String> getFilter() {
        return filter;
    }

    public void setFilter(Predicate<String> qNameFilter) {
        this.filter = qNameFilter;
    }

    public boolean shouldUseForkjoin() {
        return useForkjoin;
    }

    public void useForkjoin(boolean useForkjoin) {
        this.useForkjoin = useForkjoin;
    }
}