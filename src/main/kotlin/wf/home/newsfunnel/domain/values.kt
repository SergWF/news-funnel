package wf.home.newsfunnel.wf.home.newsfunnel.domain

import java.time.Instant

@JvmInline
value class SourceUrl(val value: String)

@JvmInline
value class RawNews(val value: String)

@JvmInline
value class Tag(val value: String)

@JvmInline
value class NewsDate(val value: Instant)

@JvmInline
value class NewsBody(val value: String)

@JvmInline
value class LinkLabel(val value: String)

@JvmInline
value class LinkDescription(val value: String)

@JvmInline
value class LinkUrl(val value: String)

data class Link(
    val label: LinkLabel,
    val description: LinkDescription,
    val url: LinkUrl,

    )

data class News(
    val sourceUrl: SourceUrl,
    val date: NewsDate,
    val tags: List<Tag> = emptyList(),
    val body: NewsBody,
    val links: List<Link> = emptyList()
)