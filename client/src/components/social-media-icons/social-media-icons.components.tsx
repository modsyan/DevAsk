import {
  AiOutlineGithub,
  AiOutlineInstagram,
  AiOutlineLinkedin,
  AiOutlineTwitter,
} from 'react-icons/ai';

export const SocialMediaIcons = () => {
  return (
    <div
      className={[
        'text-zinc-50',
        'text-2xl',
        'flex',
        'gap-4',
        'flex-col',
        '',
      ].join(' ')}
    >
      <AiOutlineGithub />
      <AiOutlineLinkedin />
      <AiOutlineTwitter />
      <AiOutlineInstagram />
    </div>
  );
};
