package com.bignerdranch.android.beatbox

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

private lateinit var beatBox: BeatBox
private lateinit var sound: Sound
private lateinit var subject: SoundViewModel

class SoundViewModelTest {

    @Before
    fun setUp() {
        beatBox = mock(BeatBox::class.java) //Создание имитации BeatBox
        sound = Sound("assetPath")
        subject = SoundViewModel(beatBox)
        subject.sound = sound
    }

    @Test
    fun exposesSoundNameAsTitle() {
        assertThat(subject.title, `is`(sound.name))
    }

    @Test
    fun callsBeatBoxPlayOnButtonClicked() {
        subject.onButtonClicked()

        verify(beatBox).play(sound)
    }
}